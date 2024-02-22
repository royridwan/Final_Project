package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiPage {
    String setURL, user_id;
    Response res;
    public String setupURL(String url) {
        switch (url) {
            case "get_list_user":
                setURL = Endpoint.get_list_user;
                break;
            case "create_user":
                setURL = Endpoint.create_user;
                break;
            case "wrong_url":
                setURL = Endpoint.wrong_url;
                break;
            default:
                System.out.println("input right url");
        }
        System.out.println("Endpoint: "+ setURL);
        return setURL;
    }

    public void hitApiGetListUser(){
        res = getListUser(setURL);
        //res.then().log().all();
    }

    public void hitApiGetListUserById() {
        System.out.println(user_id);
        res = getListUserById(setURL, user_id);
        //res.then().log().all();
    }

    public void validationStatusCodeIsEquals(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationBodyGetListUser() {
        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> title = res.jsonPath().getList("data.title");
        List<Object> firstName = res.jsonPath().getList("data.firstName");
        List<Object> lastName = res.jsonPath().getList("data.lastName");
        List<Object> picture = res.jsonPath().getList("data.picture");

        Assertions.assertThat(id.get(0)).isNotNull();
        Assertions.assertThat(title.get(0)).isIn("mr", "ms", "mrs", "miss", "dr", "");
        Assertions.assertThat(firstName.get(0)).isNotNull();
        Assertions.assertThat(lastName.get(0)).isNotNull();
        Assertions.assertThat(picture.get(0)).isNotNull();
    }

    public void validationResponseBodyNegativeGetListUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String error = jsonPathEvaluator.get("error");

        assertThat(error).isIn("PARAMS_NOT_VALID");
    }

    public void validationResponseJsonWithJSONSchema(String fileName) {
        File JSONFile = Utility.getJSONSchemaFile(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiPostCreateNewUser() {
        res = postCreateUser(setURL);
        //res.then().log().all();
    }

    public void validationResponseBodyPostCreateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String title = jsonPathEvaluator.get("title");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String gender = jsonPathEvaluator.get("gender");
        String email = jsonPathEvaluator.get("email");
        String dateOfBirth = jsonPathEvaluator.get("dateOfBirth");
        String phone = jsonPathEvaluator.get("phone");
        String picture = jsonPathEvaluator.get("picture");
        Object location = jsonPathEvaluator.get("location");
        String street = jsonPathEvaluator.get("location.street");
        String city = jsonPathEvaluator.get("location.city");
        String state = jsonPathEvaluator.get("location.state");
        String country = jsonPathEvaluator.get("location.country");
        String timezone = jsonPathEvaluator.get("location.timezone");

        assertThat(id).isNotNull();
        assertThat(title).isIn("mr", "ms", "mrs", "miss", "dr", "");
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(gender).isIn("male", "female", "other");
        assertThat(email).isNotNull();
        assertThat(dateOfBirth).isNotNull();
        assertThat(phone).isNotNull();
        assertThat(picture).isNotNull();
        assertThat(location).isNotNull();
        assertThat(street).isNotNull();
        assertThat(city).isNotNull();
        assertThat(state).isNotNull();
        assertThat(country).isNotNull();
        assertThat(timezone).isNotNull();

        user_id = id;
    }

    public void hitApiNegativePostCreateNewUser() {
        res = postNegativeCreateUser(setURL);
        //res.then().log().all();
    }

    public void validationResponseBodyNegativePostCreateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String error = jsonPathEvaluator.get("error");
        String email = jsonPathEvaluator.get("data.email");
        String firstName = jsonPathEvaluator.get("data.firstName");
        String lastName = jsonPathEvaluator.get("data.lastName");

        assertThat(error).isIn("BODY_NOT_VALID");
        assertThat(email).isIn("Path `email` is required.");
        assertThat(firstName).isIn("Path `firstName` is required.");
        assertThat(lastName).isIn("Path `lastName` is required.");
    }

    public void hitApiDeleteNewUser() {
        System.out.println(user_id);
        res = deleteUser(setURL, user_id);
        //res.then().log().all();
    }

    public void validationResponseBodyDeleteUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");

        assertThat(id).isEqualTo(user_id);
    }

    public void hitApiDeleteUserById() {
        user_id = "65c35bd3dd2c2980df26f391";
        res = deleteUser(setURL, user_id);
        //res.then().log().all();
    }

    public void validationResponseBodyNegativeDeleteUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String error = jsonPathEvaluator.get("error");

        assertThat(error).isIn("RESOURCE_NOT_FOUND");
    }

    public void hitApiUpdateUser() {
        System.out.println(user_id);
        res = updateUser(setURL, user_id);
        //res.then().log().all();
    }

    public void validationResponseBodyUpdateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
    }

}


