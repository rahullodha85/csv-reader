package parser;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Rahul Lodha on 6/7/17.
 */
public class CSVDataLoader {
    /**
     * @param headerCount
     * @return
     */
    private CellProcessor[] getProcessors(int headerCount) {
        final CellProcessor[] processors;

        ArrayList<CellProcessor> p = new ArrayList<>();
        for (int i = 0; i < headerCount; i++) {
            p.add(new Optional());
        }
        processors = p.toArray(new CellProcessor[]{});

        return processors;
    }

    /**
     * reads csv file and returns all rows except for header row as a HashTable
     * @param inputDataFile
     * @return
     * @throws IOException
     */
    public Hashtable<Integer, List<Object>> loadCSV(String inputDataFile) throws IOException {
        ICsvListReader listReader = null;
        Hashtable<Integer, List<Object>> data = new Hashtable<>();
        InputStream fis;
        try {
            if (isCSV(inputDataFile)) {
                fis = this.getClass().getClassLoader().getResourceAsStream(inputDataFile);  //new FileInputStream(inputDataFile);
            } else {
                System.out.println("Input file is not a csv file");
                return null;
            }
            listReader = new CsvListReader(new InputStreamReader(fis),
                    CsvPreference.STANDARD_PREFERENCE);

            final String[] header = listReader.getHeader(true);

            final CellProcessor[] processors = getProcessors(header.length);


            List<Object> localObject;
            while ((localObject = listReader.read(processors)) != null) {
                for (int i = 0; i < localObject.size(); i++) {
                    data.put(i + 1, localObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            listReader.close();
            return data;
        }
    }

    /**
     * checks if a file is a csv file
     * @param fileName
     * @return
     */
    protected Boolean isCSV(String fileName) {
        if (fileName.endsWith(".csv"))
            return true;
        else
            return false;
    }
}
