package SpaceShipsAndCalculation;

import ModelObjects.ResupplyPerSpaceShipPerDistance;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SpaceShipsOperationsTest {
    SpaceShipsOperations spaceShipsOperations = new SpaceShipsOperations();
    @Test
    public void spaceShipsAndMakeCalculationsNegativeMGT() {
        List<ResupplyPerSpaceShipPerDistance> results = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        results = spaceShipsOperations.spaceShipsAndMakeCalculations(-1);
        Assert.assertTrue(results.get(0).getErrMessage().equals("MGLT received is not in a correct format"));
    }

    @Test
    public void spaceShipsAndMakeCalculationsOverMAxInt() {
        List<ResupplyPerSpaceShipPerDistance> results = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        results = spaceShipsOperations.spaceShipsAndMakeCalculations(Integer.MAX_VALUE+1);
        Assert.assertTrue(results.get(0).getErrMessage().equals("MGLT received is not in a correct format"));
    }

    @Test
    public void spaceShipsAndMakeCalculations() {
        List<ResupplyPerSpaceShipPerDistance> results = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        results = spaceShipsOperations.spaceShipsAndMakeCalculations(10000000);
        Assert.assertEquals(results.get(0).getResuply(), "4.0");
        Assert.assertEquals(results.get(1).getResuply(), "195.0");
        Assert.assertEquals(results.get(2).getResuply(), "38.0");
        Assert.assertEquals(results.get(3).getResuply(), "91.0");
        Assert.assertEquals(results.get(4).getResuply(), "744.0");
        Assert.assertEquals(results.get(5).getResuply(), "595.0");
        Assert.assertEquals(results.get(6).getResuply(), "793.0");
        Assert.assertEquals(results.get(7).getResuply(), "195.0");
        Assert.assertEquals(results.get(8).getResuply(), "136.0");
        Assert.assertEquals(results.get(9).getResuply(), "14.0");
        Assert.assertEquals(results.get(10).getResuply(), "9.0");
        Assert.assertEquals(results.get(11).getResuply(), "496.0");
        Assert.assertEquals(results.get(12).getResuply(), "654.0");
        Assert.assertEquals(results.get(13).getResuply(), "unknown");
        Assert.assertEquals(results.get(14).getResuply(), "unknown");
        Assert.assertEquals(results.get(15).getResuply(), "unknown");
        Assert.assertEquals(results.get(16).getResuply(), "unknown");
        Assert.assertEquals(results.get(17).getResuply(), "unknown");
        Assert.assertEquals(results.get(18).getResuply(), "unknown");
        Assert.assertEquals(results.get(19).getResuply(), "unknown");
        Assert.assertEquals(results.get(20).getResuply(), "unknown");
        Assert.assertEquals(results.get(21).getResuply(), "9.0");
        Assert.assertEquals(results.get(22).getResuply(), "unknown");
        Assert.assertEquals(results.get(23).getResuply(), "unknown");
        Assert.assertEquals(results.get(24).getResuply(), "unknown");
        Assert.assertEquals(results.get(25).getResuply(), "114.0");
        Assert.assertEquals(results.get(26).getResuply(), "unknown");
        Assert.assertEquals(results.get(27).getResuply(), "unknown");
        Assert.assertEquals(results.get(28).getResuply(), "unknown");
        Assert.assertEquals(results.get(29).getResuply(), "unknown");
        Assert.assertEquals(results.get(30).getResuply(), "unknown");
        Assert.assertEquals(results.get(31).getResuply(), "unknown");
        Assert.assertEquals(results.get(32).getResuply(), "833.0");
        Assert.assertEquals(results.get(33).getResuply(), "unknown");
        Assert.assertEquals(results.get(34).getResuply(), "unknown");
        Assert.assertEquals(results.get(35).getResuply(), "19.0");
        Assert.assertEquals(results.get(36).getResuply(), "unknown");
    }
}
