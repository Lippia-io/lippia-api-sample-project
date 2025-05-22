package validator;

import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class CommonValidator {
    public static void validateStatusCode(String expected){
        Assert.assertEquals(expected, String.valueOf(APIManager.getLastResponse().getStatusCode()));
    }

}
