package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep(){
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.setupURL(url);
    }

    @And("hit api get list user")
    public void hitApiGetListUser() {
        apiPage.hitApiGetListUser();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get list user")
    public void validationResponseBodyGetListUser() {
        apiPage.validationBodyGetListUser();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String fileName) {
        apiPage.validationResponseJsonWithJSONSchema(fileName);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateNewUser();
    }

    @Then("validation response body post create user")
    public void validationResponseBodyPostCreateUser() {
        apiPage.validationResponseBodyPostCreateUser();
    }

    @And("hit api delete new user")
    public void hitApiDeleteNewUser() {
        apiPage.hitApiDeleteNewUser();
    }

    @Then("validation response body delete user")
    public void validationResponseBodyDeleteUser() {
        apiPage.validationResponseBodyDeleteUser();
    }

    @Then("validation response body negative delete user")
    public void validationResponseBodyNegativeDeleteUser() {
        apiPage.validationResponseBodyNegativeDeleteUser();
    }

    @And("hit api update user")
    public void hitApiUpdateUser() {
        apiPage.hitApiUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }

    @Then("validation response body negative get list user")
    public void validationResponseBodyNegativeGetListUser() {
        apiPage.validationResponseBodyNegativeGetListUser();
    }

    @And("hit api negative post create new user")
    public void hitApiNegativePostCreateNewUser() {
        apiPage.hitApiNegativePostCreateNewUser();
    }

    @Then("validation response body negative post create user")
    public void validationResponseBodyNegativePostCreateUser() {
        apiPage.validationResponseBodyNegativePostCreateUser();
    }

    @And("hit api get list user by id")
    public void hitApiGetListUserById() {
        apiPage.hitApiGetListUserById();
    }

    @And("hit api delete user by id")
    public void hitApiDeleteUserById() {
        apiPage.hitApiDeleteUserById();
    }

}
