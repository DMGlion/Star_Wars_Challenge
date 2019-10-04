package JacksonObjects;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "next",
        "previous",
        "results"
})

/**
 * This class is the outer array of SpaceShips jackson model.
 * It is used to got through the different uri of space ship
 * beccuse on next you can see included the next uri where you
 * can collect the information from the following group of
 * star ships.
 */
public class SpaceShipsOverView {

    /**
     * Total qty of star ships
     */
    @JsonProperty("count")
    private Integer count;

    /**
     * next uri for other space ships it will be null if it is the last group.
     */
    @JsonProperty("next")
    private String next;

    /**
     * previous uri of star ship, it will be null if is the first group.
     */
    @JsonProperty("previous")
    private Object previous;

    /**
     * Json inner Array of star ships
     */
    @JsonProperty("results")
    private List<SpaceShips> spaceShips = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    @JsonProperty("previous")
    public Object getPrevious() {
        return previous;
    }

    @JsonProperty("previous")
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    @JsonProperty("SpaceShips")
    public List<SpaceShips> getSpaceShips() {
        return spaceShips;
    }

    @JsonProperty("results")
    public void setSpaceShips(List<SpaceShips> spaceShips) {
        this.spaceShips = spaceShips;
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
