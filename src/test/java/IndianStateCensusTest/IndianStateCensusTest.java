package IndianStateCensusTest;


import IndianStateCensus.CustomException;
import IndianStateCensus.IndianStateCensus;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class IndianStateCensusTest {

    @Test
    public void checksState_NumberOfState() throws CsvValidationException, IOException, CustomException {
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

    @Test
    public void checking_IfFileCorrect_ButTypeIncorrect(){
        try {
            IndianStateCensus isc = new IndianStateCensus();
            isc.loadingDataFromCSV();
            Assert.assertEquals(29,isc.checkState());
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    @Test
    public void checking_ForDelimiter(){
        try {
            IndianStateCensus isc = new IndianStateCensus();
            isc.loadingDataFromCSV();
            Assert.assertEquals(29,isc.checkState());
        }
        catch (Exception e){
            e.getMessage();
        }
    }

}
