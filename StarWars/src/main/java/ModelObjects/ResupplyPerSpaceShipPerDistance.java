package ModelObjects;

public class ResupplyPerSpaceShipPerDistance {

    private String name;
    private String resupply;
    private int distance;

    public ResupplyPerSpaceShipPerDistance() {
    }

    public ResupplyPerSpaceShipPerDistance(String name) {
        this.name = name;
    }

    public ResupplyPerSpaceShipPerDistance(String name, String resupply, int distance) {
        this.name = name;
        this.resupply = resupply;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResuply() {
        return resupply;
    }

    public void setResuply(String resuply) {
        this.resupply = resuply;
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
                ", resuply=" + resupply +
                ", distance=" + distance +
                '}';
    }
}
