import parser.CSVDataLoader;

import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by 461967 on 6/5/17.
 */
public class main {

    public static void main(String[] args) throws IOException {
        CSVDataLoader loader = new CSVDataLoader();
        loader.loadCSV(args[0]);
    }
}
