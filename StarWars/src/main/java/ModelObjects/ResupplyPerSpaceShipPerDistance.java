package ModelObjects;

/**
 *This model class is to return the necessary info to the command line UI.
 * For future expansion of the app it can be expanded but the class will have to be re-named
 * in a more generic manner.
 */
public class ResupplyPerSpaceShipPerDistance {
    /**
     * name of the spaceship
     */
    private String name;

    /**
     * qty of resupply result of the function individualCalculationResupply
     */
    private String resupply;

    /**
     * distance given on MGLT
     */
    private int distance;

    /**
     * error message to cover the oublic method spaceShipsAndMakeCalculations
     */
    private String errMessage;

    /**
     * Constructor for error message when may the public class
     * spaceShipsAndMakeCalculations in a future is invoked
     * @param errMessage return an error
     */
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
