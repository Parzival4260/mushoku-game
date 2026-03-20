package progression;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AffinitySystem implements Serializable {

    private Map<String, Integer> affinities;

    public AffinitySystem() {
        affinities = new HashMap<>();
    }

    public void increaseAffinity(String character, int value) {
        affinities.put(character,
                affinities.getOrDefault(character, 0) + value);
    }

    public int getAffinity(String character) {
        return affinities.getOrDefault(character, 0);
    }
}