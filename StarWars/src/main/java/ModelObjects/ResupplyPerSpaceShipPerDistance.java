package ModelObjects;

public class ResupplyPerSpaceShipPerDistance {

    private String name;
    private String resupply;
    private int distance;
    private String errMessage;

    public ResupplyPerSpaceShipPerDistance() {
    }

    public ResupplyPerSpaceShipPerDistance(String errMessage) {
        this.errMessage = errMessage;
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

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
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
