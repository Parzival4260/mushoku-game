package story;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StoryFlagManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private Set<String> flags = new HashSet<>();

    public void activate(String flag) {
        flags.add(flag);
    }

    public boolean isActive(String flag) {
        return flags.contains(flag);
    }

    public Set<String> getFlags() {
        return flags;
    }

    public void setFlags(Set<String> flags) {
        this.flags = flags;
    }
}