package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name="data")
    public Object[][] data()
    {

        return new Object[][]{{"ritish@gmail.com", "babu123"},
            {"rakeshbabu@gmail.com", "rakesh123"},
            {"ritish@gmail.com", "ritish@123"},
            {"ritish@gmail.com", "ritish@123"},
            {"ritishbabu@gmail.com", "ritish@123"},
            {"imran@gmail.com", "imran123"}
    };
    }
}
