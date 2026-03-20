package character;

public class MainCharactersFactory {

    // =========================
    // PROTAGONISTAS
    // =========================
    public static GameCharacter createRudeus() {
        GameCharacter c = new GameCharacter(
                "Rudeus Greyrat",
                new Stats(850, 2500, 180, 150, 140, 450, 320),
                Element.WATER);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createSylphiette() {
        GameCharacter c = new GameCharacter(
                "Sylphiette",
                new Stats(700, 1800, 160, 170, 160, 350, 300),
                Element.WIND);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createRoxy() {
        GameCharacter c = new GameCharacter(
                "Roxy Migurdia",
                new Stats(650, 2200, 150, 140, 130, 420, 310),
                Element.WATER);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createEris() {
        GameCharacter c = new GameCharacter(
                "Eris Boreas Greyrat",
                new Stats(1300, 300, 420, 260, 300, 80, 120),
                Element.FIRE);
        c.setCharacterClass(GameCharacter.CharacterClass.SAINT_ASSASSIN);
        return c;
    }

    // =========================
    // FAMILIA GREYRAT
    // =========================
    public static GameCharacter createPaul() {
        GameCharacter c = new GameCharacter(
                "Paul Greyrat",
                new Stats(1100, 200, 350, 230, 260, 60, 100),
                Element.WIND);
        c.setCharacterClass(GameCharacter.CharacterClass.FIGHTER);
        return c;
    }

    public static GameCharacter createZenith() {
        GameCharacter c = new GameCharacter(
                "Zenith Greyrat",
                new Stats(800, 900, 120, 180, 120, 250, 280),
                Element.LIGHT);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createLilia() {
        GameCharacter c = new GameCharacter(
                "Lilia Greyrat",
                new Stats(750, 600, 180, 220, 140, 120, 200),
                Element.WATER);

        c.setCharacterClass(GameCharacter.CharacterClass.PALADIN);
        return c;
    }

    public static GameCharacter createNorn() {
        GameCharacter c = new GameCharacter(
                "Norn Greyrat",
                new Stats(600, 300, 150, 130, 140, 90, 120),
                Element.WIND);
        c.setCharacterClass(GameCharacter.CharacterClass.FIGHTER);
        return c;
    }

    public static GameCharacter createAisha() {
        GameCharacter c = new GameCharacter(
                "Aisha Greyrat",
                new Stats(650, 600, 170, 140, 180, 200, 160),
                Element.FIRE);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    // =========================
    // DEMON CONTINENT / AVENTUREROS
    // =========================
    public static GameCharacter createRuijerd() {
        GameCharacter c = new GameCharacter(
                "Ruijerd Superdia",
                new Stats(1800, 200, 480, 320, 340, 70, 150),
                Element.EARTH);
        c.setCharacterClass(GameCharacter.CharacterClass.FIGHTER);
        return c;
    }

    public static GameCharacter createGhislaine() {
        GameCharacter c = new GameCharacter(
                "Ghislaine Dedoldia",
                new Stats(1600, 150, 500, 300, 320, 60, 140),
                Element.EARTH);
        c.setCharacterClass(GameCharacter.CharacterClass.SAINT_ASSASSIN);
        return c;
    }

    public static GameCharacter createElinalise() {
        GameCharacter c = new GameCharacter(
                "Elinalise Dragonroad",
                new Stats(900, 400, 300, 200, 280, 120, 180),
                Element.LIGHT);
        c.setCharacterClass(GameCharacter.CharacterClass.FIGHTER);
        return c;
    }

    public static GameCharacter createTalhand() {
        GameCharacter c = new GameCharacter(
                "Talhand",
                new Stats(1200, 300, 280, 350, 150, 100, 200),
                Element.EARTH);
        c.setCharacterClass(GameCharacter.CharacterClass.PALADIN);
        return c;
    }

    // =========================
    // PODER MUNDIAL
    // =========================
    public static GameCharacter createOrsted() {
        GameCharacter c = new GameCharacter(
                "Orsted - Dios Dragón",
                new Stats(5000, 5000, 900, 900, 600, 900, 900),
                Element.DRAGON);
        c.setCharacterClass(GameCharacter.CharacterClass.DRAGON_KNIGHT);
        return c;
    }

    public static GameCharacter createHitogami() {
        GameCharacter c = new GameCharacter(
                "Hitogami - Dios Humano",
                new Stats(3000, 6000, 400, 500, 400, 1000, 1000),
                Element.DARK);
        c.setCharacterClass(GameCharacter.CharacterClass.DEMON);
        return c;
    }

    public static GameCharacter createLaplace() {
        GameCharacter c = new GameCharacter(
                "Demon God Laplace",
                new Stats(8000, 8000, 1200, 1000, 700, 1500, 1300),
                Element.DARK);
        c.setCharacterClass(GameCharacter.CharacterClass.DEMON);
        return c;
    }

    public static GameCharacter createBadigadi() {
        GameCharacter c = new GameCharacter(
                "Badigadi",
                new Stats(6000, 1000, 1000, 800, 400, 200, 300),
                Element.DARK);
        c.setCharacterClass(GameCharacter.CharacterClass.DEMON);
        return c;
    }

    public static GameCharacter createPerugius() {
        GameCharacter c = new GameCharacter(
                "Perugius Dola",
                new Stats(4000, 4000, 600, 700, 500, 800, 850),
                Element.WIND);
        c.setCharacterClass(GameCharacter.CharacterClass.DRAGON_KNIGHT);
        return c;
    }

    // =========================
    // ACADEMIA Y POLÍTICA
    // =========================
    public static GameCharacter createCliff() {
        GameCharacter c = new GameCharacter(
                "Cliff Grimoire",
                new Stats(700, 1500, 140, 150, 130, 380, 340),
                Element.LIGHT);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createZanoba() {
        GameCharacter c = new GameCharacter(
                "Zanoba Shirone",
                new Stats(2500, 100, 600, 500, 100, 50, 100),
                Element.EARTH);
        c.setCharacterClass(GameCharacter.CharacterClass.FIGHTER);
        return c;
    }

    public static GameCharacter createAriel() {
        GameCharacter c = new GameCharacter(
                "Ariel Anemoi Asura",
                new Stats(750, 1200, 160, 170, 200, 320, 300),
                Element.WIND);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createLuke() {
        GameCharacter c = new GameCharacter(
                "Luke Notos Greyrat",
                new Stats(1000, 200, 300, 220, 260, 60, 100),
                Element.WIND);
        c.setCharacterClass(GameCharacter.CharacterClass.FIGHTER);
        return c;
    }

    // =====================================================
// PERSONAJES GENÉRICOS (RECLUTABLES / ENEMIGOS)
// =====================================================
    public static GameCharacter createKnight() {
        GameCharacter c = new GameCharacter(
                "Caballero del Reino",
                new Stats(1400, 300, 320, 380, 180, 80, 150),
                Element.EARTH);
        c.setCharacterClass(GameCharacter.CharacterClass.PALADIN);
        return c;
    }

    public static GameCharacter createDarkKnight() {
        GameCharacter c = new GameCharacter(
                "Caballero Oscuro",
                new Stats(1600, 400, 380, 350, 200, 150, 200),
                Element.DARK);
        c.setCharacterClass(GameCharacter.CharacterClass.DEMON);
        return c;
    }

    public static GameCharacter createMage() {
        GameCharacter c = new GameCharacter(
                "Mago Imperial",
                new Stats(900, 2000, 120, 150, 160, 420, 320),
                Element.FIRE);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createArchMage() {
        GameCharacter c = new GameCharacter(
                "Archimago",
                new Stats(1100, 3000, 150, 180, 180, 600, 450),
                Element.WATER);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }

    public static GameCharacter createArcher() {
        GameCharacter c = new GameCharacter(
                "Arquero Élite",
                new Stats(1000, 200, 340, 200, 320, 60, 120),
                Element.WIND);
        c.setCharacterClass(GameCharacter.CharacterClass.SAINT_ASSASSIN);
        return c;
    }

    public static GameCharacter createAssassin() {
        GameCharacter c = new GameCharacter(
                "Asesino Sombrío",
                new Stats(850, 150, 420, 180, 400, 70, 100),
                Element.DARK);
        c.setCharacterClass(GameCharacter.CharacterClass.SAINT_ASSASSIN);
        return c;
    }

    public static GameCharacter createDemonSoldier() {
        GameCharacter c = new GameCharacter(
                "Soldado Demonio",
                new Stats(1700, 500, 450, 320, 220, 200, 250),
                Element.DARK);
        c.setCharacterClass(GameCharacter.CharacterClass.DEMON);
        return c;
    }

    public static GameCharacter createBeastWarrior() {
        GameCharacter c = new GameCharacter(
                "Guerrero Bestia",
                new Stats(1500, 200, 480, 260, 350, 60, 120),
                Element.EARTH);
        c.setCharacterClass(GameCharacter.CharacterClass.FIGHTER);
        return c;
    }

    public static GameCharacter createHolyPriest() {
        GameCharacter c = new GameCharacter(
                "Sacerdote Sagrado",
                new Stats(1000, 2500, 100, 200, 140, 380, 500),
                Element.LIGHT);
        c.setCharacterClass(GameCharacter.CharacterClass.MAGE);
        return c;
    }
}
