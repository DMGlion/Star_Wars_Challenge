package JacksonObjects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "model",
        "manufacturer",
        "cost_in_credits",
        "length",
        "max_atmosphering_speed",
        "crew",
        "passengers",
        "cargo_capacity",
        "consumables",
        "hyperdrive_rating",
        "MGLT",
        "starship_class",
        "pilots",
        "films",
        "created",
        "edited",
        "url"
})
/**
 * Jackson Object for the json from the API space ships
 */
public class SpaceShips {

    /**
     * name of the space ship
     */
    @JsonProperty("name")
    private String name;

    /**
     * Model of the space Ship
     */
    @JsonProperty("model")
    private String model;

    /**
     * Manufacturer of the space ship
     */
    @JsonProperty("manufacturer")
    private String manufacturer;

    /**
     * Cost of the space ship in credits
     */
    @JsonProperty("cost_in_credits")
    private String costInCredits;

    /**
     * Lenght of the space ship
     */
    @JsonProperty("length")
    private String length;

    /**
     * The maximum speed of this starship in the atmosphere.
     * "N/A" if this starship is incapable of atmospheric flight
     */
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    /**
     * The number of personnel needed to run or pilot this starship.
     */
    @JsonProperty("crew")
    private String crew;

    /**
     * The number of non-essential people this starship can transport.
     */
    @JsonProperty("passengers")
    private String passengers;

    /**
     * The maximum number of kilograms that this starship can transport.
     */
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    /**
     * The maximum length of time that this starship can provide
     * consumables for its entire crew without having to resupply.
     */
    @JsonProperty("consumables")
    private String consumables;

    /**
     * The class of this starships hyperdrive.
     */
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;

    /**
     * The Maximum number of Megalights this starship can travel in a standard hour.
     * A "Megalight" is a standard unit of distance and has never been defined
     * before within the Star Wars universe. This figure is only really useful
     * for measuring the difference in speed of starships. We can assume it is
     * similar to AU, the distance between our Sun (Sol) and Earth.
     */
    @JsonProperty("MGLT")
    private String MGLT;

    /**
     * The class of this starship, such as "Starfighter" or "Deep Space Mobile Battlestation"
     */
    @JsonProperty("starship_class")
    private String starshipClass;

    /**
     * An array of People URL Resources that this starship has been piloted by.
     */
    @JsonProperty("pilots")
    private List<String> pilots = null;

    /**
     * An array of Film URL Resources that this starship has appeared in.
     */
    @JsonProperty("films")
    private List<String> films = null;

    /**
     * the ISO 8601 date format of the time that this resource was created.
     */
    @JsonProperty("created")
    private String created;

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     */
    @JsonProperty("edited")
    private String edited;

    /**
     * the hypermedia URL of this resource.
     */
    @JsonProperty("url")
    private String url;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty("cost_in_credits")
    public String getCostInCredits() {
        return costInCredits;
    }

    @JsonProperty("cost_in_credits")
    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    @JsonProperty("length")
    public String getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(String length) {
        this.length = length;
    }

    @JsonProperty("max_atmosphering_speed")
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    @JsonProperty("max_atmosphering_speed")
    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    @JsonProperty("crew")
    public String getCrew() {
        return crew;
    }

    @JsonProperty("crew")
    public void setCrew(String crew) {
        this.crew = crew;
    }

    @JsonProperty("passengers")
    public String getPassengers() {
        return passengers;
    }

    @JsonProperty("passengers")
    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    @JsonProperty("cargo_capacity")
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    @JsonProperty("cargo_capacity")
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @JsonProperty("consumables")
    public String getConsumables() {
        return consumables;
    }

    @JsonProperty("consumables")
    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    @JsonProperty("hyperdrive_rating")
    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    @JsonProperty("hyperdrive_rating")
    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    @JsonProperty("MGLT")
    public String getMGLT() {
        return MGLT;
    }

    @JsonProperty("MGLT")
    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }

    @JsonProperty("starship_class")
    public String getStarshipClass() {
        return starshipClass;
    }

    @JsonProperty("starship_class")
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    @JsonProperty("pilots")
    public List<String> getPilots() {
        return pilots;
    }

    @JsonProperty("pilots")
    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    @JsonProperty("films")
    public List<String> getFilms() {
        return films;
    }

    @JsonProperty("films")
    public void setFilms(List<String> films) {
        this.films = films;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(String edited) {
        this.edited = edited;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
