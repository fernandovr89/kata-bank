package com.kata.bank;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OperationTestDefinitions {

  private static final String BASE_URI = "http://localhost";
  private static final String API_VERSION = "/api/v1";

  @LocalServerPort
  private int port;

  private ValidatableResponse validatableResponse;

  private void configureRestAssured() {
    RestAssured.baseURI = BASE_URI;
    RestAssured.basePath = API_VERSION;
    RestAssured.port = port;
  }

  protected RequestSpecification requestSpecification() {
    configureRestAssured();
    return given();
  }

  @Given("the client sends a request to {string} with an amount of {double}")
  public void client_sends_a_request_to_endpoint_with_an_amount_of(String endpoint, Double amount) throws Throwable {
    Map<String, Double> requestBody = new HashMap<>();
    requestBody.put("amount", amount);
    validatableResponse =
      requestSpecification().body(requestBody).contentType(ContentType.JSON).when().post(endpoint).then();
    System.out.println("RESPONSE: " + validatableResponse.extract().asString());
  }

  @Given("the client sends a request to {string} with a huge amount")
  public void client_sends_a_request_to_endpoint_with_an_amount_of(String endpoint) throws Throwable {
    Map<String, Double> requestBody = new HashMap<>();
    requestBody.put("amount", Double.MAX_VALUE);
    validatableResponse =
      requestSpecification().body(requestBody).contentType(ContentType.JSON).when().post(endpoint).then();
    System.out.println("RESPONSE: " + validatableResponse.extract().asString());
  }

  @Given("the client sends a request to {string}")
  public void client_sends_a_request_to_endpoint(String endpoint) throws Throwable {
    validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get(endpoint).then();
    System.out.println("RESPONSE: " + validatableResponse.extract().asString());
  }

  @Then("the response will return status {int} and successful message")
  public void response_will_return_OK_status_and_message(int status) {
    validatableResponse
      .assertThat()
      .statusCode(equalTo(status))
      .body(containsString("Operation completed successfully"));
  }

  @Then("the response will return status {int}")
  public void response_will_return_OK_status(int status) {
    validatableResponse.assertThat().statusCode(equalTo(status));
  }

  @Given("the client sends a request to {string} with no field called amount")
  public void client_sends_a_request_to_endpoint_with_no_amount(String endpoint) throws Throwable {
    validatableResponse = requestSpecification().body("{}").contentType(ContentType.JSON).when().post(endpoint).then();
    System.out.println("RESPONSE: " + validatableResponse.extract().asString());
  }

  @Then("the response will return status {int} and error message {string}")
  public void response_will_return_BAD_REQUEST_status(int status, String message) {
    validatableResponse.assertThat().statusCode(equalTo(status)).body(containsString(message));
  }

  @And("the client sends a request to {string} to verify his account statement")
  public void client_sends_request_to_verify_his_account_statement(String endpoint) throws Throwable {
    validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get(endpoint).then();
    System.out.println("RESPONSE: " + validatableResponse.extract().asString());
  }

  @Then("the response will return status {int} and the history with the new deposit record")
  public void response_will_return_OK_status_and_history_with_new_deposit_record(int status) {
    validatableResponse
      .assertThat()
      .statusCode(equalTo(status))
      .body(containsString("DEPOSIT"))
      .body(containsString("51.0"));
  }

  @Then("the response will return status {int} and the history with the updated balance of {double}")
  public void response_will_return_OK_status_and_history_with_updated_balance(int status, Double balance) {
    validatableResponse.assertThat().statusCode(equalTo(status)).body(containsString(balance.toString()));
  }
}
