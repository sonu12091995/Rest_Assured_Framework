package org.RestAssured.Pojo.Response_pojo_Restfull;

import org.RestAssured.Pojo.Request_pojo_Restfull.Booking;

public class BookingResponse {
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

    private Integer bookingid;
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}



