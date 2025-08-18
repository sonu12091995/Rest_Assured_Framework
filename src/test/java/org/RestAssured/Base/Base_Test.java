package org.RestAssured.Base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.RestAssured.Assertion.AssertActions;
import org.RestAssured.Endpoints.APIConstants;
import org.RestAssured.Module.payloadManager;
import org.testng.annotations.BeforeTest;

public class Base_Test {
    // This is called as common to all test cases.
    // CommonToAll Testcase
    //   // Base URL, Content Type - json - common

    public RequestSpecification requestSpecification;
    public Response response;

    public ValidatableResponse validatableResponse;

    public AssertActions assertActions;
    public payloadManager payloadManager;
    public JsonPath jsonPath;

    @BeforeTest
    public void setup() {

        System.out.println("Starting of the Test");
        payloadManager = new payloadManager();
        assertActions = new AssertActions();

//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri(APIConstants.BASE_URL);
//        requestSpecification.contentType(ContentType.JSON).log().all();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();


    }
}
