package IndianStateCensus;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.shape.Path;

public class IndianStateCensus {
    ArrayList<StateCensusData> scd = new ArrayList<>();
    StateCensusData tempObj;

    public int checkState() throws CsvValidationException, IOException, CustomException {
            IndianStateCensus asc = new IndianStateCensus();
            asc.loadingDataFromCSV();
            return (asc.scd.size());
    }

    public void loadingDataFromCSV() throws IOException, CsvValidationException, CustomException {
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

            try{
                tempObj = new StateCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(DensityPerSqKm));
                scd.add(tempObj);
            }
            catch (Exception e){
                throw new CustomException("Type incoorect");
            }
        }
        System.out.println();
    }

    public int checkingFileIfExists() throws CustomException {
        File file = new File("C:\\Nikhil\\bridgelabz\\IndianStateCensus\\CSVFiles\\IndiaStateCensusData.csv");
        if (file.exists()){
            return 1;
        }
        else {
            throw new CustomException("File not found");
        }
    }
}

