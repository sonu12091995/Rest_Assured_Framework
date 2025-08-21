package org.RestAssured.Test.RestBooker.CRUD;

import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAssured.Base.Base_Test;
import org.RestAssured.Endpoints.APIConstants;

import org.RestAssured.Pojo.Response_pojo_Restfull.BookingResponse;
import org.testng.annotations.Test;

public class Create_token extends Base_Test {

    @Test(groups = "Reg", priority = 1)
    @Owner("Sonu")
    public void tokenGenerated(){
        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthtoken()).post();
        // Extraction ( JSON String response to Java Object)
        String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println(token);
    }

    @Test(groups = "Reg", priority = 2)
    @Owner("Sonu")
    public void tokenInvalid(){
        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification).when()
                .body("{}").post();

        // Extraction ( JSON String response to Java Object)
        String invalidReason = payloadManager.invalidCredential(response.asString());
        System.out.println(invalidReason);

       //Assertion
        assertActions.verifyStringKey(invalidReason,"Bad credentials");


    }


}
