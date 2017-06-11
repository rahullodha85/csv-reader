package parser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Rahul Lodha on 6/10/17.
 */
public class catMouseTest {
    CSVDataLoader loader;
    List<Integer> list;

    /**
     * test setup initializing reader object and valid cat and dog value list
     */
    @BeforeTest
    public void setup(){
        loader = new CSVDataLoader();
        list = Arrays.asList(0, 1);
    }

    /**
     * test for invalid combination of cats and dogs in same row ex. (1,1)
     * @throws IOException
     */
    @Test
    public void invalidCombinationValues() throws IOException {
        Hashtable<Integer, List<Object>> dataList = loader.loadCSV("invalidCatsDogs.csv");
        for (List<Object> data :
                dataList.values()) {
            for (Object cell:
                 data) {
                assertFalse(list.contains(cell), "Invalid State: " + cell.toString());
            }
            assertEquals(Integer.parseInt(data.get(0).toString()) ^ Integer.parseInt(data.get(1).toString()), 0);
        }
    }

    /**
     * test for non integer and values other than 1 and 0 as inputs for cat and dog
     * @throws IOException
     */
    @Test
    public void nonIntegerValues() throws IOException {
        Hashtable<Integer, List<Object>> dataList = loader.loadCSV("nonIntegerCatsDogs.csv");
        for (List<Object> data :
                dataList.values()) {
            for (Object cell:
                    data) {
                assertFalse(list.contains(cell), "Invalid State: " + cell.toString());
            }
        }
    }

    /**
     * test for valid values/combinations as inputs for cat and dog ex. (0,1) or (1,0)
     * @throws IOException
     */
    @Test
    public void validValues() throws IOException {
        Hashtable<Integer, List<Object>> dataList = loader.loadCSV("catsDogs.csv");
        for (List<Object> data :
                dataList.values()) {
            for (Object cell:
                    data) {
                assertFalse(list.contains(cell), "Invalid State: " + cell.toString());
            }
            assertEquals(Integer.parseInt(data.get(0).toString()) ^ Integer.parseInt(data.get(1).toString()), 1,
                    "invalid combination of cat and mouse: " + data.get(0) + " and " + data.get(1));
        }
    }
}