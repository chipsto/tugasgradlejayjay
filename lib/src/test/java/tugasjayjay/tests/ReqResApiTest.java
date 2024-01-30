package tugasjayjay.tests;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import tugasjayjay.request.ReqResApiClient;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
public class ReqResApiTest {
    private static final ReqResApiClient reqResApiClient = new ReqResApiClient();

        @BeforeClass
    public static void setup() {
       
        RestAssured.baseURI = reqResApiClient.getBaseUrl();
    }
     @Test
     public void testGetUserByIdPositiveCaseRestAssured() throws IOException{
         RestAssured.given().when()
         .get("/users/2")
         .then().log().all()
         .assertThat().statusCode(200)
         .assertThat().body("data.id", Matchers.equalTo(2));
     }

     @Test
     public void testGetUserByIdNegativeCaseRestAssured() throws IOException{
         RestAssured.given().when()
         .get("/users/99999")
         .then().log().all()
         .assertThat().statusCode(404);
     }


}
