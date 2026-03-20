package worldMap;

public class Trigger {

    private String type; // TELEPORT, EVENT
    private String targetMap;
    private int targetX;
    private int targetY;

    public Trigger(String type, String targetMap, int targetX, int targetY) {
        this.type = type;
        this.targetMap = targetMap;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public String getType() {
        return type;
    }

    public String getTargetMap() {
        return targetMap;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }
}
