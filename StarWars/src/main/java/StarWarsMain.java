
import API.GetRequestRepository;
import API.API;
import JacksonObjects.SpaceShips;
import JacksonObjects.SpaceShipsOverView;
import ModelObjects.ResupplyPerSpaceShipPerDistance;
import SpaceShipsAndCalculation.SpaceShipsOperations;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
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
