package producttests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import reader.NewPropertyFileReader;
import util.ApiUtilities;
import util.PropertiesReader;

public class ProductBaseTest {

    static String baseURI;
    Response response;
    NewPropertyFileReader propertyFileReader;

    public ProductBaseTest(){
    }

    static void envDetails() {
        PropertiesReader.load(System.getProperty("user.dir") + "/src/main/resources/env.properties");
        baseURI = PropertiesReader.get("url");
        ApiUtilities.setBaseURI(baseURI);
    }

    @BeforeSuite
    public void setUp() {
        propertyFileReader = new NewPropertyFileReader();
        String path = System.getProperty("user.dir") + "/src/main/resources/product.properties";
        propertyFileReader.setPropertyFile(path);
        envDetails();
        RestAssured.baseURI = baseURI;
    }

}
