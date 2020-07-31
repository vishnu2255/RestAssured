package producttests;

import api.ProductApi;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import template.ProductP;
import util.ApiUtilities;
import util.PropertiesReader;

import static org.hamcrest.Matchers.*;

public class GetProductTest extends ProductBaseTest {


    String validProductId;
    String inValidProductId="3232251959";

    @BeforeClass
    public void setUp() {

        RestAssured.baseURI = "http://localhost:3030/";
        response = ProductApi.createNewProduct();
//        response = ProductApi.createNewProduct();
        response.then()
                .statusCode(201);
        response.then().assertThat().body("type", equalTo(PropertiesReader.get("type")));
        validProductId=""+response.then().extract().path("id");
        System.out.println(validProductId);
    }

    @Test
    public void getValidSpecificProduct(){
        response = ProductApi.getSpecificProduct(validProductId);
        response.then().log().all().statusCode(200);
        ProductP productP = response.getBody().as(ProductP.class);
        System.out.println(productP.id + " from responsev");
        Assert.assertTrue(Long.parseLong(validProductId) == (productP.id));
        response.then().assertThat().body("id", equalTo(Integer.parseInt(validProductId)));
    }

    @Test
    public void getInvalidSpecificProduct(){
        response = ProductApi.getSpecificProduct(inValidProductId);
        response.then().statusCode(404);
    }
}

