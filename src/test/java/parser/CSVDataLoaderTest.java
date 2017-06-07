package parser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by 461967 on 6/7/17.
 */
public class CSVDataLoaderTest {

    CSVDataLoader loader;

    @BeforeTest
    public void setup(){
         loader = new CSVDataLoader();
    }
}