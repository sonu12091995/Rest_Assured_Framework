package org.RestAssured.Test.RestBooker.CRUD;

import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.RestAssured.Base.Base_Test;
import org.RestAssured.Endpoints.APIConstants;
import org.testng.annotations.Test;

public class Health_check extends Base_Test {

    // No nedd the payload and pjojos
    @Test
    @Description("TC#3  - Verify Health")
    public void testGETHealthCheck() {
        requestSpecification.basePath(APIConstants.PING_URL);

        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


        assertActions.verifyTrue(response.asString().contains("Created"));


    }
}
