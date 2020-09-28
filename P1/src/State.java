/**
 * Class representing the state on the polar coordinates grid i.e. a coordinate point
 */

public class State {

    // This is the number of the meridian
    private int level;
    // This the angle from the bearing i.e. 0 radians line
    private int bearing;
    // Explored
    private boolean explored;

    public State(int level, int bearing) {
        this.level = level;
        this.bearing = bearing;
        this.explored = false;
    }

    @Override
    public String toString() {
        return (level + "," + bearing);
    }

    public int getLevel() {
        return level;
    }

    public int getBearing() {
        return bearing;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {

        this.explored = explored;
    }
}
