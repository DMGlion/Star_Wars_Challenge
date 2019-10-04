
public class StarWarsMain {
    /**
     * As part of a code challenge I have used an API available here: https://swapi.co/  
     * This app displays how many stops for resupply are required to cover a given distance,
     * The application is taking as input a distance in mega lights (MGLT) given by an user
     * The output is a collection of all the star ships and the total amount of stops required to make the distance between the planets.
     * Future application will be added soon.
     *
     * @author David Moya
     *
     * @param args {@link String} Input arguments.
     */
    public static void main(String[] args) {
        UserActionScanner userActionScanner = new UserActionScanner();
        userActionScanner.actionScanner();
    }
}
