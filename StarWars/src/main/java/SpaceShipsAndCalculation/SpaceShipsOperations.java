package SpaceShipsAndCalculation;

import API.API;
import API.GetRequestRepository;
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
    public List<ResupplyPerSpaceShipPerDistance> SpaceShipsAndMAkeCAlculations(int MGLT){
        List<ResupplyPerSpaceShipPerDistance> results = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        List<SpaceShips> spaceShips = getSpaceShips();
        for (SpaceShips s: spaceShips){
            results.add(new ResupplyPerSpaceShipPerDistance(s.getName()));
        }
        return results;
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
        for (SpaceShips s: enums){
            totalSpaceShips.add(s);
        }
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
