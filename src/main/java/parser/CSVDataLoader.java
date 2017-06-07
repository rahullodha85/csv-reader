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
import java.util.List;

/**
 * Created by Rahul Lodha on 6/5/17.
 */
public class CSVDataLoader {
    private CellProcessor[] getProcessors(int headerCount) {
        final CellProcessor[] processors;

        ArrayList<CellProcessor> p = new ArrayList<>();
        for (int i = 0; i < headerCount; i++) {
            p.add(new Optional());
        }
        processors = p.toArray(new CellProcessor[]{});

        return processors;
    }

    protected int[] getStartColumnIndex(String[] header) {
        int totalCol = 0;
        int colIdx = 0;

        for (int i = 0; i < header.length; i++) {
            totalCol++;
        }
        return new int[]{colIdx, totalCol};
    }

    public void loadCSV(String inputDataFile) throws IOException {
        ICsvListReader listReader = null;
        try {
            InputStream fis = this.getClass().getClassLoader().getResourceAsStream(inputDataFile);  //new FileInputStream(inputDataFile);
            listReader = new CsvListReader(new InputStreamReader(fis),
                    CsvPreference.STANDARD_PREFERENCE);

            final String[] header = listReader.getHeader(true);
            int[] result = getStartColumnIndex(header);//, "state");
            int firstColIndx = result[0];
            int totalCol = result[1];

            final CellProcessor[] processors = getProcessors(header.length);

            List<Object> localObject;
            while ((localObject = listReader.read(processors)) != null) {
                System.out.println(String.format("lineNo=%s, rowNo=%s, localObject=%s", listReader.getLineNumber(),
                        listReader.getRowNumber(), localObject));
                for (int i = 0; i < localObject.size(); i++) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            listReader.close();
        }
    }
}
