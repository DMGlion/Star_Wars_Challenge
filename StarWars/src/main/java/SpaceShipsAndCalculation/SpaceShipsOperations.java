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

public class SpaceShipsOperations {
    public List<ResupplyPerSpaceShipPerDistance> spaceShipsAndMakeCalculations(int MGLT) {
        List<ResupplyPerSpaceShipPerDistance> results;
        List<SpaceShips> spaceShips = getSpaceShips();
        results = qtyOfResupplyPerDistance(spaceShips, MGLT);

        return results;
    }

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

    private String calculateResupply(String consumables, String mglt, int Distance) {
            String [] valuesConsumables = consumables.split(" ");
            if (valuesConsumables[1].equals(Consumables.DAY) || valuesConsumables[1].equals(Consumables.DAYS)){
                return String.valueOf(Math.floor((Distance/Float.parseFloat(mglt))/
                        ((Float.parseFloat(valuesConsumables[0])* Consumables.DAY_HOURS))));
            }else if (valuesConsumables[1].equals(Consumables.WEEK) || valuesConsumables[1].equals(Consumables.WEEKS)){
                return String.valueOf(Math.floor((Distance/Float.parseFloat(mglt))/
                        ((Float.parseFloat(valuesConsumables[0])* Consumables.WEEK_HOURS))));
            }else if (valuesConsumables[1].equals(Consumables.MONTH) || valuesConsumables[1].equals(Consumables.MONTHS)){
                return String.valueOf(Math.floor((Distance/Float.parseFloat(mglt))/
                        ((Float.parseFloat(valuesConsumables[0])* Consumables.MONTH_HOURS))));
            }else if (valuesConsumables[1].equals(Consumables.YEAR) || valuesConsumables[1].equals(Consumables.YEARS)){
                return String.valueOf(Math.floor((Distance/Float.parseFloat(mglt))/
                        ((Float.parseFloat(valuesConsumables[0])* Consumables.YEAR_HOURS))));
            }
        System.out.println(valuesConsumables[0]);
        return "";
    }

    private List<SpaceShips> getSpaceShips() {
        API api = new API();

        List<SpaceShips> totalSpaceShips = new ArrayList<SpaceShips>();
        Gson gson = new Gson();
        GetRequestRepository requestRepository = new GetRequestRepository(api);
        JsonObject jsonObject = requestRepository.getAll("starships", null);

        //Get next uri
        SpaceShipsOverView spaceShipsOverView = gson.fromJson(jsonObject, SpaceShipsOverView.class);

        //Get SpaceShips
        JsonArray resultsSpaceships = jsonObject.getAsJsonArray("results");
        Type collectionType = new TypeToken<Collection<SpaceShips>>(){}.getType();
        Collection<SpaceShips> enums = gson.fromJson(resultsSpaceships, collectionType);
        totalSpaceShips.addAll(enums);

        while (spaceShipsOverView.getNext()!=null) {
            String valueUri = spaceShipsOverView.getNext();
            String [] splited = valueUri.split("/");
            jsonObject = requestRepository.getAll("starships/"+splited[splited.length-1],null);

            //Get next uri
            spaceShipsOverView = gson.fromJson(jsonObject, SpaceShipsOverView.class);

            //Get SpaceShips
            resultsSpaceships = jsonObject.getAsJsonArray("results");
            collectionType = new TypeToken<Collection<SpaceShips>>(){}.getType();
            enums = gson.fromJson(resultsSpaceships, collectionType);
            for (SpaceShips s: enums){
                totalSpaceShips.add(s);
            }
        }
        return totalSpaceShips;
    }
}
