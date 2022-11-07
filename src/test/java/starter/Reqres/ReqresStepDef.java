package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //skenario 1
    @Given("Post Register with valid json")
    public void postRegisterWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/Register.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("Send Post Register request")
    public void sendPostRegisterRequest() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should contain id {int} and token {string}")
    public void responseBodyPageShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate Register json schema")
    public void validateRegisterJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/RegisterJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //skenario 2
    @Given("Post Register with invalid json")
    public void postRegisterWithInvalidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/FailRegister.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("Send Post FailRegister request")
    public void sendPostFailRegisterRequest() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int fail) {
        SerenityRest.then().statusCode(fail);
    }

    @And("Response body page should contain error {string}")
    public void responseBodyPageShouldContainError(String fail) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(fail));
    }
    @And("Validate Register invalid json schema")
    public void validateRegisterInvalidJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/InvalidRegisterJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //skenario 3
    @Given("Post Login with valid json")
    public void postLoginWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/Login.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send Post Login request")
    public void sendPostLoginRequest() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @Then("status code login should be {int} OK")
    public void statusCodeLoginShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should contain token {string}")
    public void responseBodyPageShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate Login json schema")
    public void validateLoginJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/LoginJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//skenario 4

    @Given("Post Login with invalid json")
    public void postLoginWithInvalidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/FailLogin.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send Post Fail Login request")
    public void sendPostFailLoginRequest() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @Then("status code login should be {int}")
    public void statusCodeLoginShouldBe(int fail) {
        SerenityRest.then().statusCode(fail);
    }

    @And("Response body page should contain error Login {string}")
    public void responseBodyPageShouldContainErrorLogin(String fail) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(fail));
    }
    @And("Validate Invalid Login json schema")
    public void validateInvalidLoginJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/InvalidLoginJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //skenario 5
    @Given("Post create user with invalid json")
    public void postCreateUserWithInValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/CreateUserID.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body page should contain name and job {string}")
    public void responseBodyPageShouldContainNameJobIdAndCreatedAt(String job) {
        SerenityRest.and()
                .body(ReqresResponses.JOB, equalTo(job));
    }
    @And("Validate Invalid Create User json schema")
    public void validateInvalidCreateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/InvalidCreateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //skenario 6
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code get list should be {int} OK")
    public void statusCodeGetListShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body("page", equalTo(page));
    }
    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //skenario 7
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/UpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Response body page should contain name {string} and job {string}")
    public void responseBodyPageShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }
    @And("Validate put update user json schema")
    public void validatePutUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/UpdateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
    //skenario 8
    @Given("Delete user with id {int}")
    public void deleteUserWithIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

}

