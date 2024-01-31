package tugasjayjay.tests;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import tugasjayjay.request.ReqResApiClient;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
public class ReqResApiTest {
    private static final ReqResApiClient reqResApiClient = new ReqResApiClient();

        @BeforeClass
    public static void setup() {
       
        RestAssured.baseURI = reqResApiClient.getBaseUrl();
    }
     @Test
     public void testGetUserByIdPositiveCaseRestAssured() throws IOException{
        File jsonschema = reqResApiClient.jsonSchema();

         RestAssured.given().when()
         .get("/users?page=2")
         .then().log().all()
         .assertThat().statusCode(200)
         .assertThat().body("data[0].id", Matchers.equalTo(7))
         .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonschema));
     }

     @Test
     public void testGetUserByIdNegativeCaseRestAssured() throws IOException{
         RestAssured.given().when()
         .get("/users/99999")
         .then().log().all()
         .assertThat().statusCode(404);
     }

     @Test
    public void testGetUserByIdWithMinimumValue() {
        int userId = 1;  // Minimum value for userId

        RestAssured.given().when()
                .get("/users/" + userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("data.id", Matchers.equalTo(userId));
    }

    @Test
    public void testGetUserByIdWithMaximumValue() {
        int userId = Integer.MAX_VALUE;  

        RestAssured.given().when()
                .get("/users/" + userId)
                .then().log().all()
                .assertThat().statusCode(404);  
    }


}
