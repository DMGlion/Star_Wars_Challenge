
import API.GetRequestRepository;
import API.API;
import JacksonObjects.SpaceShips;
import JacksonObjects.SpaceShipsOverView;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class StarWarsMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the intergalactic travel");
        API api = new API();




        List<SpaceShips> totalSpaceShips = new ArrayList<SpaceShips>();
        Gson gson = new Gson();
        GetRequestRepository requestRepository = new GetRequestRepository(api);
        JsonObject jsonObject = requestRepository.getAll("starships", null);

        //Get next uri
        SpaceShipsOverView spaceShipsOverView = gson.fromJson(jsonObject, SpaceShipsOverView.class);
        System.out.println(spaceShipsOverView.getNext());

        //Get SpaceShips
        JsonArray resultsSpaceships = jsonObject.getAsJsonArray("results");
        Type collectionType = new TypeToken<Collection<SpaceShips>>(){}.getType();
        Collection<SpaceShips> enums = gson.fromJson(resultsSpaceships, collectionType);
        for (SpaceShips s: enums){
            totalSpaceShips.add(s);
            System.out.println(s.getName());
        }
        while (spaceShipsOverView.getNext()!=null) {
            String valueUri = spaceShipsOverView.getNext();
            String [] splited = valueUri.split("/");
            jsonObject = requestRepository.getAll("starships/"+splited[splited.length-1],null);

            //Get next uri
            spaceShipsOverView = gson.fromJson(jsonObject, SpaceShipsOverView.class);
            System.out.println(spaceShipsOverView.getNext());

            //Get SpaceShips
            resultsSpaceships = jsonObject.getAsJsonArray("results");
            collectionType = new TypeToken<Collection<SpaceShips>>(){}.getType();
            enums = gson.fromJson(resultsSpaceships, collectionType);
            for (SpaceShips s: enums){
                totalSpaceShips.add(s);
                System.out.println(s.getName());
            }
        }
    }
}
