package parser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Rahul Lodha on 6/10/17.
 */
public class stateCsvTest {

    CSVDataLoader loader;
    List<String> states;

    /**
     * Test setup initializing reader object and states list
     */
    @BeforeTest
    public void setup() {
        loader = new CSVDataLoader();
        states = Arrays.asList("AL", "AK", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA",
                "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
                "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
    }

    /**
     * valid states
     * @throws IOException
     */
    @Test
    public void validStates() throws IOException {
        Hashtable<Integer, List<Object>> dataList = loader.loadCSV("states.csv");
        for (List<Object> data :
                dataList.values()) {
            assertTrue(states.contains(data.get(0).toString()), "Invalid State: " + data.get(0).toString());
        }
    }

    /**
     * invalid states test
     * @throws IOException
     */
    @Test
    void invalidStates() throws IOException {
        Hashtable<Integer, List<Object>> dataList = loader.loadCSV("invalidStates.csv");
        for (List<Object> data :
                dataList.values()) {
            assertFalse(states.contains(data.get(0).toString()));
        }
    }
}
