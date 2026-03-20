package story;

import character.Party;
import worldMap.WorldMap;
import core.Difficulty;

public interface Act {

    void start(Party party, WorldMap worldMap, Difficulty difficulty);

    void update(Party party, WorldMap worldMap);

    boolean isCompleted();
}

