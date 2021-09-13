package IndianStateCensusTest;


import IndianStateCensus.CustomException;
import IndianStateCensus.IndianStateCensus;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class IndianStateCensusTest {

    @Test
    public void checksState_NumberOfState() throws CsvValidationException, IOException {
        IndianStateCensus isc = new IndianStateCensus();
        Assert.assertEquals(29,isc.checkState());

    }

    @Test
    public void checkCensusCSV_IsCorrect(){
        try {
            IndianStateCensus isc = new IndianStateCensus();
            Assert.assertEquals(1,isc.checkingFileIfExists());
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

}
