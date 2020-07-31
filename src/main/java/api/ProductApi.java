package api;

import template.Product;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ProductApi {


    final static String product = "/products";

    public static Response getAllProducts()
    {
        return given()
                .contentType("application/json")
                .log().all()
                .when()
                .get(product);
    }

    public static Response getSpecificProduct(String productId)
    {
        return given()
                .log().all()
                .when()
                .get(String.format("%s/%s",product, productId));
    }


    public static Response deleteSpecificProduct(String productId)
    {
        return given()
                .log().all()
                .when()
                .delete(String.format("%s/%s",product, productId));
    }


    public static Response createNewProduct()
    {
        return given()
                .contentType("application/json")
                .body(Product.getProductDetails())
                .log().all()
                .when()
                .post(product);

    }



    public static Response updateProduct(String productId)
    {
        return given()
                .contentType("application/json")
                .body(Product.getUpdatedProductDetails())
                .log().all()
                .when()
                .patch(String.format("%s/%s",product, productId));

    }


}
