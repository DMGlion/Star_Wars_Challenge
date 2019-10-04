package SpaceShipsAndCalculation;

import API.API;
import API.GetRequestRepository;
import ConstantsConsumables.Consumables;
import JacksonObjects.SpaceShips;
import JacksonObjects.SpaceShipsOverView;
import ModelObjects.ResupplyPerSpaceShipPerDistance;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * The SpaceShipOperation class Collect all the Star Wars spaceship available from the API
 * https://swapi.co/ and return all the information from them encapsulated in the object
 * ResupplyPerSpaceShipPerDistance and also it calculates how many resupply is needed for a given distance
 * on MGLT
 * @author David Moya
 */
public class SpaceShipsOperations {

    /**
     * Results of information to be displayed to the user including the qty of resupply per distanc
     * @param MGLT distance on MGLT
     * @return ResupplyPerSpaceShipPerDistance with all calculations realised in relation of resupply
     */
    public List<ResupplyPerSpaceShipPerDistance> spaceShipsAndMakeCalculations(int MGLT) {

            List<ResupplyPerSpaceShipPerDistance> results = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        if(validateUserInput(MGLT)) {
            List<SpaceShips> spaceShips = getSpaceShips();
            results = qtyOfResupplyPerDistance(spaceShips, MGLT);
        }else {
            results.add(new ResupplyPerSpaceShipPerDistance("MGLT received is not in a correct format"));
        }
        return results;
    }

    /**
     * validation of the vulnerability of public method spaceShipsAndMakeCalculations
     * @param distance distance on MGLT
     * @return boolean
     */
    private boolean validateUserInput(int distance){
        return distance>0
                && distance<Integer.MAX_VALUE;
    }

    /**
     * Determining if one of the factor of calculation is unknown such consumables and MGLT
     * @param spaceShips list of space ship using the jackson Object model SpaceShips
     * @param MGLT Distance on MGLT
     * @return return Object ResupplyPerSpaceShipPerDistance for Command line UI.
     */
    private List<ResupplyPerSpaceShipPerDistance> qtyOfResupplyPerDistance(List<SpaceShips> spaceShips, int MGLT) {
        List<ResupplyPerSpaceShipPerDistance> results = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        for (SpaceShips s: spaceShips){
            if (!s.getConsumables().equals("unknown") && !s.getMGLT().equals("unknown")) {
                results.add(new ResupplyPerSpaceShipPerDistance(s.getName(),
                        calculateResupply(s.getConsumables(), s.getMGLT(), MGLT),
                        MGLT));
            }else {
                results.add(new ResupplyPerSpaceShipPerDistance(s.getName(),
                        "unknown",
                        MGLT));
            }
        }
        return results;
    }

    /**
     * process of pre-calculation to convert an amount of time of consumables
     * @param consumables Consumables
     * @param mglt MGLT cover by star ship in hours
     * @param Distance distance on MGLT
     * @return individualCalculationResupply
     */
    private String calculateResupply(String consumables, String mglt, int Distance) {
            String [] valuesConsumables = consumables.split(" ");

            if (valuesConsumables[1].equals(Consumables.DAY) ||
                    valuesConsumables[1].equals(Consumables.DAYS)){

                 return individualCalculationResupply(valuesConsumables, mglt, Distance, Consumables.DAY_HOURS);
            }else if (valuesConsumables[1].equals(Consumables.WEEK)
                    || valuesConsumables[1].equals(Consumables.WEEKS)){

                return individualCalculationResupply(valuesConsumables, mglt, Distance, Consumables.WEEK_HOURS);
            }else if (valuesConsumables[1].equals(Consumables.MONTH)
                    || valuesConsumables[1].equals(Consumables.MONTHS)){

                return individualCalculationResupply(valuesConsumables, mglt, Distance, Consumables.MONTH_HOURS);
            }else if (valuesConsumables[1].equals(Consumables.YEAR)
                    || valuesConsumables[1].equals(Consumables.YEARS)){

                return individualCalculationResupply(valuesConsumables, mglt, Distance, Consumables.YEAR_HOURS);
            }
        System.out.println(valuesConsumables[0]);
        return "";
    }

    /**
     * Function to calculate the qty of resupply based on the distance on MGLT, MGLT per hour and consumable resistance.
     * @param valuesConsumables consumables splited by qty
     * @param mglt MGLT star ship can cover in hourd
     * @param Distance distance to cover on MGLT
     * @param hours time spca ship can travle without repo
     * @return All the start ships available one the API
     */
    private String individualCalculationResupply(String[] valuesConsumables, String mglt, int Distance, int hours){
        return String.valueOf(Math.floor((Distance/Float.parseFloat(mglt))/
                ((Float.parseFloat(valuesConsumables[0]) * hours))));
    }


    /**
     * Collecting all spaceships from api and adding them to their object model
     * @return return list with all space ships avalable on the API
     */
    private List<SpaceShips> getSpaceShips() {
        API api = new API();

        List<SpaceShips> totalSpaceShips = new ArrayList<SpaceShips>();
        Gson gson = new Gson();
        GetRequestRepository requestRepository = new GetRequestRepository(api);

        JsonObject jsonObject = requestRepository.getAll("starships", null);


        /**
         * Get next uri
         */
        SpaceShipsOverView spaceShipsOverView = gson.fromJson(jsonObject, SpaceShipsOverView.class);


        /**
         * Get SpaceShips
         */
        JsonArray resultsSpaceships = jsonObject.getAsJsonArray("results");
        Type collectionType = new TypeToken<Collection<SpaceShips>>(){}.getType();
        Collection<SpaceShips> enums = gson.fromJson(resultsSpaceships, collectionType);
        totalSpaceShips.addAll(enums);

        while (spaceShipsOverView.getNext()!=null) {
            String valueUri = spaceShipsOverView.getNext();
            String [] splited = valueUri.split("/");

            jsonObject = requestRepository.getAll("starships/"+splited[splited.length-1],null);

            /**
             * Get next uri
             */
            spaceShipsOverView = gson.fromJson(jsonObject, SpaceShipsOverView.class);

            /**
             * Get SpaceShips
             */
            resultsSpaceships = jsonObject.getAsJsonArray("results");
            collectionType = new TypeToken<Collection<SpaceShips>>(){}.getType();
            enums = gson.fromJson(resultsSpaceships, collectionType);
            totalSpaceShips.addAll(enums);
        }
        return totalSpaceShips;
    }
}
