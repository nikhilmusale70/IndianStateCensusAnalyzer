package IndianStateCode;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IndianStateCode {
    ArrayList<IndianStateData> scd = new ArrayList<>();
    IndianStateData tempObj;

    public int checkStateData() throws CsvValidationException, IOException {
        IndianStateCode asc = new IndianStateCode();
        asc.loadingStateDataFromCSV();
        System.out.println(asc.scd.size());
        return (asc.scd.size());
    }
    public void loadingStateDataFromCSV() throws IOException, CsvValidationException {

        FileReader fr = new FileReader("C:\\Nikhil\\bridgelabz\\IndianStateCensus\\CSVFiles\\StateCode.csv");
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader csvReader = new CSVReaderBuilder(fr).withCSVParser(parser).build();
        String[] nextLine;

        nextLine = csvReader.readNext();
        while ((nextLine = csvReader.readNext()) != null) {

            Iterator<String> it = Arrays.stream(nextLine).iterator();
            String state = it.next();
            String population = it.next();
            String areaInSqKm = it.next();
            String DensityPerSqKm = it.next();

            tempObj = new IndianStateData(Integer.parseInt(state), population, Integer.parseInt(areaInSqKm), DensityPerSqKm);
            scd.add(tempObj);
        }
        System.out.println();

    }
}
