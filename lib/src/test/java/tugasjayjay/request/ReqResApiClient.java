package tugasjayjay.request;
import java.io.File;

public class ReqResApiClient {
    private final String baseURL = "https://reqres.in/api";
    public String getBaseUrl(){

        return baseURL;
    }
    
    public static File jsonSchema(){
        File jsonSchemaFile = new File("src/test/java/tugasjayjay/Utility/getlistUser.json");

        return jsonSchemaFile;
    }
}
