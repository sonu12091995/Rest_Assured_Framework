package org.RestAssured.Pojo.Response_pojo_Restfull;

import org.RestAssured.Pojo.Request_pojo_Restfull.Booking;

public class Response {
    // Response pojo

    /*{
    "bookingid": 16867,
    "booking": {
        "firstname": "viki",
        "lastname": "Sharma",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}*/
   // Class representing the booking response
    public class BookingResponse {

        // Unique ID for the booking
        private String bookingId;

        // Booking details (reusing BookingParent class)
        private Booking booking;

        // Getter and Setter for bookingId
        public String getBookingId() {
            return bookingId;
        }

        public void setBookingId(String bookingId) {
            this.bookingId = bookingId;
        }

        // Getter and Setter for booking
        public Booking getBooking() {
            return booking;
        }

        public void setBooking(Booking booking) {
            this.booking = booking;
        }
    }



}
