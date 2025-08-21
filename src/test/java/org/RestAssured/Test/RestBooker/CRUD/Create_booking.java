package org.RestAssured.Test.RestBooker.CRUD;

import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.RestAssured.Base.Base_Test;
import org.RestAssured.Endpoints.APIConstants;
import org.RestAssured.Module.payloadManager;
import org.RestAssured.Pojo.Response_pojo_Restfull.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Create_booking extends Base_Test {


    @Test(groups = "reg", priority = 1)
    @Owner("Sonu Sharma")
    @Description("TC#1_ Verify the Booking can created")
    public void testCreateBookingPOST_Positive() {

        // Setup will first and making the request - Part - 1
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .log().all().post();

        //Extraction Part - 2
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());


        // Validation and verification via the AssertJ, TestNG Part - 3
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Lucky");

    }

    @Test(groups = "reg", priority = 1)
    @Owner("sonu sharma")
    @Description("TC#2 - Verify that the Booking can't be Created, When Payload is null")
    public void testCreateBookingPOST_Negative() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body("{}").log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);

    }

    @Test(groups = "reg", priority = 1)
    @Owner("Pramod Dutta")
    @Description("TC#3 - Verify that the Booking can be Created, When Payload is CHINESE")
    public void testCreateBookingPOST_POSITIVE_CHINESE() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.createPayloadBookingAsStringWrongBody())// chinese method call(createPayloadBookingAsStringWrongBody)
                .log().all().post();

        // only check status code
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        // Extract step=2
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());

    }

    @Test(groups = "reg",priority = 1)
    @Owner("Sonu sharma")
    @Description("TC#4- Verify that the random data add ")
    public void Fake_random_data() {
       requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
       response = RestAssured.given(requestSpecification)
               .when().body(payloadManager.createPayloadBookingFakerJS())
               .log().all().post();

// Deseilization


        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());    }
}
