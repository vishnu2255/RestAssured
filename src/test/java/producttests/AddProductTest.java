package producttests;

import api.ProductApi;
import org.testng.annotations.Test;
import util.PropertiesReader;
import static org.hamcrest.Matchers.equalTo;

public class AddProductTest extends ProductBaseTest{


    @Test
    public void createNewProduct() {
        System.out.println(propertyFileReader.getProp("name"));
        response = ProductApi.createNewProduct();
        response.then().statusCode(201);
        response.then().assertThat().body("name", equalTo(PropertiesReader.get("name")))
        .body("price", equalTo(Integer.parseInt(PropertiesReader.get("price"))))
        .body("shipping", equalTo(Integer.parseInt(PropertiesReader.get("shipping"))))
        .body("type", equalTo(PropertiesReader.get("type")));
    }
}
