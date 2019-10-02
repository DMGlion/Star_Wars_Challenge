package ModelObjects;

public class ResupplyPerSpaceShipPerDistance {

    private String name;
    private float resuply;
    private int distance;

    public ResupplyPerSpaceShipPerDistance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getResuply() {
        return resuply;
    }

    public void setResuply(float resuply) {
        this.resuply = resuply;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ResupplyPerSpaceShipPerDistance{" +
                "name='" + name + '\'' +
                ", resuply=" + resuply +
                ", distance=" + distance +
                '}';
    }
}
