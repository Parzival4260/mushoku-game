package story;

import character.Party;
import worldMap.WorldMap;
import core.Difficulty;

import java.io.Serializable;

public class StoryManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private int currentAct;
    private StoryFlagManager flags;

    public StoryManager() {
        this.currentAct = 0;
        this.flags = new StoryFlagManager();
    }

    public int getCurrentAct() {
        return currentAct;
    }

    public void setCurrentAct(int act) {
        this.currentAct = act;
    }

    public StoryFlagManager getFlags() {
        return flags;
    }

    // =========================
    // INICIAR ACTO ACTUAL
    // =========================

    public void startCurrentAct(Party party, WorldMap worldMap, Difficulty difficulty) {

        switch (currentAct) {
            case 0:
                Act0_Prologue.start(party, worldMap, this, difficulty);
                break;

            case 1:
                Act1_BuenaVillage.start(party, worldMap, this);
                break;

            case 2:
                Act2_DemonContinent.start(party, worldMap, this);
                break;

            case 3:
                Act3_ReturnJourney.start(party, worldMap, this);
                break;

            case 4:
                Act4_MagicAcademy.start(party, worldMap, this);
                break;

            case 5:
                Act5_AsuraPolitics.start(party, worldMap, this);
                break;

            case 6:
                Act6_OrstedArc.start(party, worldMap, this);
                break;

            case 7:
                Act7_FinalWar.start(party, worldMap, this);
                break;
        }
    }

    // Método especial para iniciar Acto 0 directamente
    public void startAct0(Party party, WorldMap worldMap, Difficulty difficulty) {
        currentAct = 0;
        startCurrentAct(party, worldMap, difficulty);
    }
}
