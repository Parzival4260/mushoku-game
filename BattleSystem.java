package BattleSystem;

import character.*;
import core.Difficulty;

import java.util.*;

public class BattleSystem {

    private Difficulty difficulty;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";

    public BattleSystem(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    // =====================================================
    // INICIO COMBATE
    // =====================================================
    public void startBattle(Party playerParty, Party enemyParty) {

        System.out.println(YELLOW + "===== ⚔ COMBATE INICIADO ⚔ =====" + RESET);

        while (!playerParty.isDefeated() && !enemyParty.isDefeated()) {

            printBattleStatus(playerParty, enemyParty);

            List<GameCharacter> turnOrder = new ArrayList<>();
            turnOrder.addAll(playerParty.getAliveMembers());
            turnOrder.addAll(enemyParty.getAliveMembers());

            turnOrder.sort(Comparator.comparingInt(
                    c -> -c.getEffectiveStat(StatType.SPEED)));

            for (GameCharacter character : turnOrder) {

                if (!character.getStats().isAlive()) {
                    continue;
                }

                character.processStatusEffects();
                character.processBuffs();

                // 🔥 Reducir cooldowns
                for (Skill s : character.getEquippedSkills()) {
                    s.reduceCooldown();
                }

                if (!character.getStats().isAlive()) {
                    continue;
                }

                if (character.isUnableToMove()) {
                    System.out.println(RED + character.getName()
                            + " no puede moverse!" + RESET);
                    continue;
                }

                if (playerParty.getMembers().contains(character)) {
                    playerTurn(character, playerParty, enemyParty);
                } else {
                    enemyTurn(character, playerParty);
                }

                if (playerParty.isDefeated() || enemyParty.isDefeated()) {
                    break;
                }
            }

            System.out.println("---------------------------------\n");
        }

        // 🔥 Reset post combate
        for (GameCharacter c : playerParty.getMembers()) {
            c.clearBuffs();
            c.recoverAfterBattle();
            c.resetSpecialEnergy();

            for (Skill s : c.getEquippedSkills()) {
                s.resetBattleUses();
            }
        }

        for (GameCharacter c : enemyParty.getMembers()) {
            c.clearBuffs();
        }

        if (!playerParty.isDefeated()) {
            System.out.println(GREEN + "🏆 ¡Victoria!" + RESET);
        } else {
            System.out.println(RED + "☠ Derrota..." + RESET);
        }
    }

    // =====================================================
    // TURNO JUGADOR
    // =====================================================
    private void playerTurn(GameCharacter character,
            Party playerParty,
            Party enemyParty) {

        boolean turnConsumed = false;

        while (!turnConsumed) {

            System.out.println("\nTurno de " + character.getName());
            System.out.println("Energía Especial: "
                    + character.getSpecialEnergy() + "/100");

            System.out.println("1. Atacar");
            System.out.println("2. Habilidades");
            System.out.println("3. Objetos");
            System.out.println("4. Defender");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    basicAttack(character,
                            enemyParty.getAliveMembers().get(0));
                    turnConsumed = true;
                    break;

                case 2:
                    turnConsumed = useSkill(character, enemyParty);
                    break;

                case 3:
                    turnConsumed = openItemMenu(playerParty);
                    break;

                case 4:
                    defend(character);
                    turnConsumed = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // =====================================================
    // ATAQUE BÁSICO
    // =====================================================
    private void basicAttack(GameCharacter attacker,
            GameCharacter target) {

        int attack = attacker.getEffectiveStat(StatType.ATTACK);
        int defense = target.getEffectiveStat(StatType.DEFENSE);

        int damage = attack - defense / 2;

        if (damage < 1) {
            damage = 1;
        }

        // ===== CRÍTICO =====
        double critChance = 0.10
                + (attacker.getStats().getToukiLevel() * 0.02);

        boolean critical = random.nextDouble() < critChance;

        if (critical) {
            double critMultiplier = critical ? 1.5 : 1.0;
            damage *= critMultiplier;
        }

        // ===== TOUKI BOOST FÍSICO =====
        damage *= attacker.getStats().getPhysicalBoostFromTouki();

        // ===== TOUKI REDUCCIÓN DEFENSOR =====
        damage *= target.getStats().getPhysicalReductionFromTouki();

        damage *= 0.95 + (random.nextDouble() * 0.1);

        target.getStats().receiveDamage((int) damage);

        attacker.addSpecialEnergy(15);

        System.out.println(attacker.getName()
                + " ataca y causa "
                + CYAN + (int) damage + RESET + " daño.");

        if (critical) {
            System.out.println(YELLOW + "¡Golpe crítico!" + RESET);
        }
    }

    // =====================================================
    // DEFENDER
    // =====================================================
    private void defend(GameCharacter character) {

        character.setDefending(true);

        character.addBuff(
                new StatModifier(StatType.DEFENSE, 10, 0.10, 1));

        character.addSpecialEnergy(10);

        System.out.println(character.getName()
                + " adopta posición defensiva.");
    }

    // =====================================================
    // HABILIDADES
    // =====================================================
    private boolean useSkill(GameCharacter character,
            Party enemyParty) {

        List<Skill> skills = character.getEquippedSkills();

        if (skills.isEmpty()) {
            System.out.println("No tiene habilidades.");
            return false;
        }

        for (int i = 0; i < skills.size(); i++) {
            Skill s = skills.get(i);

            System.out.println((i + 1) + ". "
                    + s.getName()
                    + (s.isSpecial()
                    ? " [Especial | Energía: "
                    + s.getEnergyCost() + "]"
                    : ""));
        }

        System.out.println("0. Volver");

        int option = scanner.nextInt() - 1;
        scanner.nextLine();

        if (option == -1) {
            return false;
        }

        if (option < 0 || option >= skills.size()) {
            System.out.println("Opción inválida.");
            return false;
        }

        Skill selectedSkill = skills.get(option);

        if (!selectedSkill.canUse(character.getSpecialEnergy())) {
            System.out.println("No puede usar esta habilidad ahora.");
            return false;
        }

        if (selectedSkill.isSpecial()) {
            character.consumeSpecialEnergy(
                    selectedSkill.getEnergyCost());
        }

        if (selectedSkill.isMultiTarget()) {

            for (GameCharacter enemy : enemyParty.getAliveMembers()) {
                executeDamage(character, enemy, selectedSkill, false);
            }

        } else {

            GameCharacter target = enemyParty.getAliveMembers().get(0);
            executeDamage(character, target, selectedSkill, false);
        }

        character.addSpecialEnergy(10);

        return true;
    }

    // =====================================================
    // OBJETOS
    // =====================================================
    private boolean openItemMenu(Party playerParty) {

        Inventory inventory = playerParty.getInventory();
        List<InventorySlot> slots = inventory.getSlots();

        if (slots.isEmpty()) {
            System.out.println("Inventario vacío.");
            return false;
        }

        inventory.printInventory();
        System.out.println("0. Volver");

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 0) {
            return false;
        }

        if (option < 1 || option > slots.size()) {
            System.out.println("Opción inválida.");
            return false;
        }

        InventorySlot slot = slots.get(option - 1);
        Item item = slot.getItem();

        useItem(playerParty, item);

        return true; // usar objeto consume turno
    }

    private void useItem(Party party, Item item) {

        GameCharacter target
                = party.getAliveMembers().get(0);

        switch (item.getType()) {

            case CONSUMABLE:
                target.getStats().heal(100);
                System.out.println("Se usó "
                        + item.getName()
                        + " y recuperó 100 HP.");
                break;

            case SCROLL:

                String skillId = item.getLinkedSkillId();

                Skill skill = SkillDatabase.getSkill(skillId);

                if (skill == null) {
                    skill = SpecialSkillDatabase.getSkill(skillId);
                }

                if (skill != null) {

                    GameCharacter targetCharacter
                            = party.getAliveMembers().get(0);

                    targetCharacter.learnSkill(skill);

                    System.out.println("Nueva habilidad desbloqueada!");
                }

                break;

            default:
                System.out.println("No usable en combate.");
                return;
        }

        party.getInventory()
                .removeItem(item.getId(), 1);
    }

    // =====================================================
    // ENEMIGO
    // =====================================================
    private void enemyTurn(GameCharacter character,
            Party playerParty) {

        GameCharacter target
                = playerParty.getAliveMembers().get(0);

        List<Skill> skills
                = character.getEquippedSkills();

        if (skills.isEmpty()) {
            basicAttack(character, target);
            return;
        }

        Skill selectedSkill = null;

        switch (difficulty) {

            case AVENTURERO:
                selectedSkill
                        = skills.get(random.nextInt(skills.size()));
                break;

            case ESPADACHIN:
                selectedSkill
                        = skills.stream()
                                .filter(s -> s.canUse(character.getSpecialEnergy()))
                                .findFirst()
                                .orElse(skills.get(0));
                break;

            case RENACIDO:
                selectedSkill
                        = skills.stream()
                                .filter(s -> s.canUse(character.getSpecialEnergy()))
                                .max(Comparator.comparingInt(Skill::getPower))
                                .orElse(skills.get(0));
                break;
        }

        executeSkill(character, target,
                selectedSkill, true);
    }

    // =====================================================
    // EJECUTOR GENERAL
    // =====================================================
    private void executeSkill(GameCharacter caster,
            GameCharacter target,
            Skill skill,
            boolean isEnemy) {

        switch (skill.getType()) {

            case DAMAGE:
                executeDamage(caster, target,
                        skill, isEnemy);
                break;

            case HEAL:
                int healAmount
                        = skill.getPower()
                        + caster.getEffectiveStat(
                                StatType.ATTACK);

                caster.getStats().heal(healAmount);

                System.out.println(caster.getName()
                        + " se cura "
                        + GREEN + healAmount
                        + RESET + " HP.");
                break;

            case BUFF:
                if (skill.getBuffModifier() != null) {
                    caster.addBuff(skill.getBuffModifier());
                }
                System.out.println("Buff aplicado.");
                break;
        }

        skill.registerUse();
    }

    private void executeDamage(GameCharacter attacker,
            GameCharacter target,
            Skill skill,
            boolean isEnemy) {

        int attack;
        int defense;

        // 🔥 SEPARACIÓN FÍSICO / MÁGICO
        if (skill.isMagical()) {
            attack = attacker.getEffectiveStat(StatType.MAGIC_ATTACK);
            defense = target.getEffectiveStat(StatType.MAGIC_DEFENSE);
        } else {
            attack = attacker.getEffectiveStat(StatType.ATTACK);
            defense = target.getEffectiveStat(StatType.DEFENSE);
        }

        int damage = skill.getPower() + attack - defense / 2;

        // ===== EVASIÓN =====
        int attackerSpeed = attacker.getEffectiveStat(StatType.SPEED);
        int targetSpeed = target.getEffectiveStat(StatType.SPEED);

        double dodgeChance = (targetSpeed - attackerSpeed) * 0.002;

        if (dodgeChance < 0) {
            dodgeChance = 0;
        }
        if (dodgeChance > 0.25) {
            dodgeChance = 0.25;
        }

        if (random.nextDouble() < dodgeChance) {
            System.out.println(target.getName() + " esquivó el ataque!");
            return;
        }

        if (damage < 1) {
            damage = 1;
        }

        // ===== DEFENSA ACTIVA =====
        if (target.isDefending()) {
            damage *= 0.70;
            target.setDefending(false);
        }

        // ===== CRÍTICO =====
        double critChance = 0.10
                + (attacker.getStats().getToukiLevel() * 0.02)
                + ((attackerSpeed - targetSpeed) * 0.001);

        if (critChance < 0) {
            critChance = 0;
        }
        if (critChance > 0.40) {
            critChance = 0.40;
        }

        boolean critical = random.nextDouble() < critChance;

        double critMultiplier = critical ? 1.5 : 1.0;

        if (!skill.isMagical()) {

            // Solo físico usa reducción física
            damage *= attacker.getStats().getPhysicalBoostFromTouki();
            damage *= target.getStats().getPhysicalReductionFromTouki();

        } else {

            // Magia usa afinidad/resistencia directamente
            Element element = attacker.getElement();

            damage *= attacker.getStats().getAffinity(element);
            damage *= target.getStats().getResistance(element);
        }

        // ===== ELEMENTAL BÁSICO =====
        Element atkElement = attacker.getElement();
        damage *= attacker.getStats().getAffinity(atkElement);
        damage *= target.getStats().getResistance(atkElement);

        // ===== DIFICULTAD ENEMIGA =====
        if (isEnemy) {
            damage *= difficulty.getEnemyDamageMultiplier();
        }

        // ===== VARIACIÓN =====
        damage *= 0.95 + (random.nextDouble() * 0.1);

        target.getStats().receiveDamage((int) damage);

        System.out.println(attacker.getName()
                + " usa " + skill.getName()
                + " y causa "
                + CYAN + (int) damage
                + RESET + " daño.");

        if (critical) {
            System.out.println(YELLOW
                    + "¡Golpe crítico!"
                    + RESET);
        }
        if (target instanceof BossCharacter){
            ((BossCharacter)target).checkPhaseChange();
        }
    }

    // =====================================================
    // ESTADO
    // =====================================================
    private void printBattleStatus(Party playerParty,
            Party enemyParty) {

        System.out.println("\n===== ESTADO =====");

        for (GameCharacter c
                : playerParty.getAliveMembers()) {

            System.out.println(CYAN + c.getName()
                    + RESET
                    + " | HP: "
                    + c.getStats().getCurrentHP()
                    + "/"
                    + c.getStats().getMaxHP()
                    + " | MP: "
                    + c.getStats().getCurrentMP()
                    + "/"
                    + c.getStats().getMaxMP());
        }

        System.out.println("------------------");

        for (GameCharacter c
                : enemyParty.getAliveMembers()) {

            System.out.println(RED + c.getName()
                    + RESET
                    + " | HP: "
                    + c.getStats().getCurrentHP()
                    + "/"
                    + c.getStats().getMaxHP());
        }

        System.out.println("==================\n");
    }
}
