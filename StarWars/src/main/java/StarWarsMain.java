import ModelObjects.ResupplyPerSpaceShipPerDistance;
import SpaceShipsAndCalculation.SpaceShipsOperations;
import java.util.List;


public class StarWarsMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the intergalactic travel");

        SpaceShipsOperations spaceShipsOperations = new SpaceShipsOperations();
        List<ResupplyPerSpaceShipPerDistance> result = spaceShipsOperations.SpaceShipsAndMAkeCAlculations(10000);

        for (ResupplyPerSpaceShipPerDistance s: result){
            System.out.println(s.toString());
        }


    }
}
