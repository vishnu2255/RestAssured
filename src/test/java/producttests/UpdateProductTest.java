package producttests;

import api.ProductApi;
import io.restassured.RestAssured;
import org.testng.annotations.*;
import template.Product;
import util.PropertiesReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateProductTest extends ProductBaseTest{

    String validProductId;
    String inValidProductId="3224234234234242";

    @BeforeClass
    public void setUp() {
        envDetails();
        RestAssured.baseURI = baseURI;
        response = ProductApi.createNewProduct();
        response.then().statusCode(201);
        validProductId=""+response.then().extract().path("id");
    }

    @Test
    public void updateValidSpecificProduct(){
        response = ProductApi.updateProduct(validProductId);
        response.then().statusCode(200);
        response.then().assertThat().body("id", equalTo(Integer.parseInt(validProductId)));
        response.then().assertThat().body("name", equalTo(PropertiesReader.get("name1")));
    }

    @Test
    public void updateInValidProduct() {
        response = ProductApi.updateProduct(inValidProductId);
        response.then().statusCode(404);
    }

    @Test
    public void updateWithInValidProductBody() {
    response = given()
            .body(Product.getUpdatedProductDetails())
            .log().all()
            .when()
            .patch(String.format("%s/%s","/products", validProductId));
    }
}

