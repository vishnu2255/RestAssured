package util;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public final class ApiUtilities {

    private static RequestSpecification requestSpec;
    private static String accessToken;
    private static RestAssuredConfig requestConfig;
    private static ValidatableResponse response;
    private static String token;

    public ApiUtilities(){}

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        ApiUtilities.token = token;
    }

    public static String getBaseURI(){
        return RestAssured.baseURI;
    }

    public static void setBaseURI(String baseURI){
        RestAssured.baseURI = baseURI;
    }

    public static boolean validateStatusCode(Integer statusCode){
        return response.extract().statusCode() == statusCode;
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }

    public static void setRequestSpec(RequestSpecification requestSpec) {
        ApiUtilities.requestSpec = requestSpec;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        ApiUtilities.accessToken = accessToken;
    }

    public static RestAssuredConfig getRequestConfig() {
        return requestConfig;
    }

    public static void setRequestConfig(RestAssuredConfig requestConfig) {
        ApiUtilities.requestConfig = requestConfig;
    }

    public static ValidatableResponse getResponse() {
        return response;
    }

    public static void setResponse(ValidatableResponse response) {
        ApiUtilities.response = response;
    }
}
