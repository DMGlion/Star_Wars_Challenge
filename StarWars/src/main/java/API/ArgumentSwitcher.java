package API;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArgumentSwitcher {

    private static final API apiCalls = new API();
    private GetRequestRepository repository = new GetRequestRepository(apiCalls);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Printer printer = new Printer();

    public void switcher(String command, String searchquery) {

        JsonObject jsonObject;

        if ("films".equals(command)) {
            jsonObject = repository.getAll("films", searchquery);
            JsonArray filmresults = jsonObject.getAsJsonArray("results");
            printer.printDetailsFilms(filmresults);
        } else if ("planets".equals(command)) {
            jsonObject = repository.getAll("planets", searchquery);
            JsonArray planetresults = jsonObject.getAsJsonArray("results");
            printer.printDetailsPlanets(planetresults);
        } else if ("starships".equals(command)) {
            jsonObject = repository.getAll("starships", searchquery);
            JsonArray starshipresults = jsonObject.getAsJsonArray("results");
            printer.printDetailsStarships(starshipresults);
        } else {
            System.out.println(command + " is not a available command");
        }
    }
}
