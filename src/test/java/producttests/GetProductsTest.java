package producttests;

import java.util.List;

import api.ProductApi;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import template.ProductP;

public class GetProductsTest extends ProductBaseTest{


    @Test
    public void getAllProducts(){
        response = ProductApi.getAllProducts();
        System.out.println(response.getBody());
        ProductP[] productPList = response.getBody().as(ProductP[].class);
        System.out.println(productPList.length);
        response.then().log().all()
                .statusCode(200);
    }

}

