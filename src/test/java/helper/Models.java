package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.*;

public class Models {
    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "65be10319de882aab5dd2395");
    }

    public static Response getListUser(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response getListUserById(String endpoint, String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().get(finalEndpoint);
    }

    public static Response postCreateUser(String endpoint) {
        setupHeaders();

        String title = "mr";
        String firstName = "Ridwan Jaya";
        String lastName = "Tama";
        String gender = "male";
        String email = generateRandomEmail();
        String dateOfBirth = "05/26/1999";
        String phone = generateRandomPhoneNumber();
        String picture = "https://www.greenscene.co.id/wp-content/uploads/2022/07/Gojo.jpg";
        String street = "Sesetan Street";
        String city = "Denpasar";
        String state = "Bali";
        String country = "Indonesia";
        String timezone = "+7:00";

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("dateOfBirth", dateOfBirth);
        payload.put("phone", phone);
        payload.put("picture", picture);

        JSONObject location = new JSONObject();
        payload.put("location", location);
        location.put("street", street);
        location.put("city", city);
        location.put("state", state);
        location.put("country", country);
        location.put("timezone", timezone);

        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response postNegativeCreateUser(String endpoint) {
        setupHeaders();

        String title = "mr";
        String firstName = "";
        String lastName = "";
        String gender = "male";
        String email = "";

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("gender", gender);
        payload.put("email", email);

        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String user_id) {
        setupHeaders();

        String firstName = "Ridwan Edit";
        String phone = generateRandomPhoneNumber();
        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("phone", phone);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().put(finalEndpoint);
    }
}
