package IndianStateCensusTest;

import IndianStateCensus.*;
import IndianStateCensus.CustomException;
import IndianStateCensus.IndianStateCensus;
import IndianStateCode.IndianStateCode;
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

    @Test
    public void checking_HeaderIsCorrect(){
        try {
            IndianStateCensus isc = new IndianStateCensus();
            isc.loadingDataFromCSV();
            Assert.assertEquals(29,isc.checkState());
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    @Test //uc2
    public void checkingIf_ReadProperly_FromCsv() throws CsvValidationException, IOException, CustomException {
        IndianStateCensus iscensus = new IndianStateCensus();
        IndianStateCode isc = new IndianStateCode();
        Assert.assertEquals(37,isc.checkStateData());
    }

    

}
