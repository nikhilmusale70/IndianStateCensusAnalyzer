package IndianStateCensusTest;

import IndianStateCensus.IndianStateCensus;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class IndianStateCensusTest {

    @Test
    public void checksState_NumberOfState() throws CsvValidationException, IOException {
        IndianStateCensus isc = new IndianStateCensus();
        isc.checkState();
    }

    

}
