package org.example.service.general;

import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * Abstract base class for web service endpoints. Provides common functionalities for making HTTP
 * requests using RestAssured.
 */
public abstract class AbstractWebEndpoint {

  protected RequestSpecification specification;

  /**
   * Constructor for AbstractWebEndpoint with a specified RequestSpecification.
   *
   * @param specification The RequestSpecification to use for HTTP requests.
   */
  protected AbstractWebEndpoint(RequestSpecification specification) {
    this.specification = specification;
  }

  /**
   * Performs a GET request to the specified path.
   *
   * @param requestSpecification Additional specifications for the request.
   * @param path                 The endpoint path.
   * @return The response of the request as a ValidatableResponse.
   */
  @Step("Performs a GET request to the specified path")
  public ValidatableResponse get(RequestSpecification requestSpecification, String path) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    return RestAssured.given()
        .spec(specBuilder.build())
        .when()
        .get(path)
        .then();
  }

  /**
   * Performs a GET request to the specified path with path parameters.
   *
   * @param requestSpecification Additional specifications for the request.
   * @param path                 The endpoint path.
   * @param pathParams           Parameters to be replaced in the path template.
   * @return The response of the request as a ValidatableResponse.
   */
  @Step("Performs a GET request to the specified path with path parameters")
  public ValidatableResponse get(RequestSpecification requestSpecification, String path,
      Object... pathParams) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    return RestAssured.given()
        .spec(specBuilder.build())
        .when()
        .get(path, pathParams)
        .then();
  }

  /**
   * Performs a POST request to the specified path with a body payload and path parameters.
   *
   * @param requestSpecification Additional specifications for the request.
   * @param path                 The endpoint path.
   * @param bodyPayload          The payload to be sent in the body of the request.
   * @param pathParams           Parameters to be replaced in the path template.
   * @return The response of the request as a ValidatableResponse.
   */
  @Step("Performs a POST request to the specified path with a body payload and path parameters")
  public ValidatableResponse post(RequestSpecification requestSpecification, String path,
      Object bodyPayload, Object... pathParams) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    if (bodyPayload != null) {
      specBuilder.setBody(bodyPayload);
    }
    return RestAssured.given()
        .spec(specBuilder.build())
        .when()
        .post(path, pathParams)
        .then();
  }

  /**
   * Performs a PUT request to the specified path with a body payload and path parameters.
   *
   * @param requestSpecification Additional specifications for the request.
   * @param path                 The endpoint path.
   * @param bodyPayload          The payload to be sent in the body of the request.
   * @param pathParams           Parameters to be replaced in the path template.
   * @return The response of the request as a ValidatableResponse.
   */
  @Step("Performs a PUT request to the specified path with a body payload and path parameters")
  public ValidatableResponse put(RequestSpecification requestSpecification, String path,
      Object bodyPayload, Object... pathParams) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    if (bodyPayload != null) {
      specBuilder.setBody(bodyPayload);
    }
    return given()
        .spec(specBuilder.build())
        .when()
        .put(path, pathParams)
        .then();
  }
}
