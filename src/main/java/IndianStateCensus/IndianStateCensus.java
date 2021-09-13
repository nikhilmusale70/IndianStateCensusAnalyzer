package IndianStateCensus;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class IndianStateCensus {
    ArrayList<StateCensusData> scd = new ArrayList<>();
    StateCensusData tempObj;

    public int checkState() throws CsvValidationException, IOException {
            IndianStateCensus asc = new IndianStateCensus();
            asc.loadingDataFromCSV();
            return (asc.scd.size());
    }

    public void loadingDataFromCSV() throws IOException, CsvValidationException {
        FileReader fr = new FileReader("C:\\Nikhil\\bridgelabz\\IndianStateCensus\\CSVFiles\\IndiaStateCensusData.csv");
        CSVReader csvReader = new CSVReader(fr);
        String[] nextLine;

        nextLine = csvReader.readNext();
        while ((nextLine = csvReader.readNext()) != null) {

            Iterator<String> it = Arrays.stream(nextLine).iterator();
            String state = it.next();
            String population = it.next();
            String areaInSqKm = it.next();
            String DensityPerSqKm = it.next();

            tempObj = new StateCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(DensityPerSqKm));
            scd.add(tempObj);
        }
        System.out.println();
    }
}

