package tugasjayjay.tests;

import org.junit.Test;

import tugasjayjay.request.ReqResApiClient;

import static org.junit.Assert.*;

import java.io.IOException;
public class ReqResApiTest {
     private final ReqResApiClient reqResApiClient = new ReqResApiClient();

    @Test
    public void testCreateUserPositiveCase() throws IOException {
        String response = reqResApiClient.createUser("John Doe", "Software Engineer");
        assertEquals("HTTP/1.1 201 Created", response);
    }

    @Test
    public void testGetUserByIdPositiveCase() throws IOException {
        // Assuming user with ID 2 exists in ReqRes.in
        String response = reqResApiClient.getUserById(3);
        assertEquals("HTTP/1.1 200 OK", response);
    }

    @Test
    public void testCreateUserNegativeCase() throws IOException {
        // Sending invalid data, expecting a 400 Bad Request response
        String response = reqResApiClient.createUser("a", "Invalid Job");
        assertEquals("HTTP/1.1 400 Bad Request", response);
    }

    @Test
    public void testGetUserByIdNegativeCase() throws IOException {
        // Assuming user with ID 999 does not exist
        String response = reqResApiClient.getUserById(999);
        assertEquals("HTTP/1.1 404 Not Found", response);
    }

    @Test
    public void testCreateUserBoundaryCase() throws IOException {
        // Sending data with maximum allowed length, expecting a 201 Created response
        String name = "a".repeat(256); // Assuming maximum length is 255
        String job = "a".repeat(256);
        String response = reqResApiClient.createUser(name, job);
        assertEquals("HTTP/1.1 201 Created", response);
    }

    @Test
    public void testGetUserByIdBoundaryCase() throws IOException {
        // Assuming user with ID 1 exists, testing the minimum and maximum ID values
        String responseMin = reqResApiClient.getUserById(2);
        assertEquals("HTTP/1.1 200 OK", responseMin);

        // Assuming user with ID 2147483647 exists (maximum signed 32-bit integer)
        String responseMax = reqResApiClient.getUserById(2147483643);
        assertEquals("HTTP/1.1 200 OK", responseMax);
    }
}
