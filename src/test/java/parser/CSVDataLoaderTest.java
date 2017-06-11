package parser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Rahul Lodha on 6/7/17.
 */
public class CSVDataLoaderTest {

    CSVDataLoader loader;

    /**
     * Test setup to initialize reader object
     */
    @BeforeTest
    public void setup() {
        loader = new CSVDataLoader();
    }

    /**
     * a valid csv file as input
     * @throws Exception
     */
    @Test
    public void validCsv() throws Exception {
        assertTrue(loader.isCSV("states.csv"));
        assertNotNull(loader.loadCSV("states.csv"));
    }

//    @Test(expectedExceptions = java.lang.NullPointerException.class)
//    public void emptyCsv() throws Exception{
//        Hashtable<Integer, List<Object>> data = loader.loadCSV("empty.csv");
//    }

    /**
     * non csv file as input
     * @throws Exception
     */
    @Test
    public void nonCsv() throws Exception {
        assertFalse(loader.isCSV("test.txt"));
    }
}