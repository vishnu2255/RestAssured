package util;

import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class APIOperationUtils {

    private static final String GET_TOKEN_ENDPOINT = "URL.API.TOKEN";
    private static final String URL = "URL.API.BASEPATH";

        public void setupUrl() {

        }

        public String authenticateUser(String role) {
            String username = "";
            String password = "";
            String client_id = "";
            String client_secret = "";

            String response = given()
                .port(8080)
                .params("username", username, "password", password,
                    "grant_type", "password", "scope", "openid")
                .auth()
                .preemptive()
                .basic(client_id, client_secret)
                .when()
                .get((GET_TOKEN_ENDPOINT))
                .then().log().ifError().extract().asString();
            JsonPath jsonPath = new JsonPath(response);
            return jsonPath.getString("access_token");
        }
}