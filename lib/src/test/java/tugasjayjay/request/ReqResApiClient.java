package tugasjayjay.request;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class ReqResApiClient {
    private final String baseUrl = "https://reqres.in/api";

    public String createUser(String name, String job) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(baseUrl + "/users");
        StringEntity params = new StringEntity("{\"name\":\"" + name + "\",\"job\":\"" + job + "\"}");
        request.addHeader("content-type", "application/json");
        request.setEntity(params);
        return httpClient.execute(request, httpResponse -> httpResponse.getStatusLine().toString());
    }

    public String getUserById(int userId) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + "/users/" + userId);
        return httpClient.execute(request, httpResponse -> httpResponse.getStatusLine().toString());
    }
}
