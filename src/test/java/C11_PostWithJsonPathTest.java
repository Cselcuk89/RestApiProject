import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class C11_PostWithJsonPathTest {
    @Test
    public void test01(){
        /*
        * send post request to https://restful-booker.herokuapp.com/booking
        along with the request payload below:
                            {
                    "firstname" : "Ahmet",
                     "lastname" : “Bulut",
                     "totalprice" : 500,
                     "depositpaid" : false,
                     "bookingdates" : {
                            "checkin" : "2023-01-10",
                            "checkout" : "2023-01-20"
                            },
                    "additionalneeds" : "wi-fi"
                    }
           * verify that status code is 200
           * content type is application/json
           * verify every corresponding items in response payload with request payload
         */

        // create end point and request body
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject outerJson = new JSONObject();
        JSONObject innerJson = new JSONObject();
        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");
        outerJson.put("firstname","Jim");
        outerJson.put("lastname","Brown");
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("bookingdates",innerJson);
        outerJson.put("additionalneeds","Breakfast");
        //create expected data
        //send post request and store the response
        Response response = given().contentType(ContentType.JSON)
                            .when().body(outerJson).post(url);
        //assertions

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("Jim"),
                        "booking.lastname",equalTo("Brown"),
                        "booking.totalprice",equalTo(111),
                        "booking.depositpaid",equalTo(true),
                        "booking.bookingdates.checkin",equalTo("2018-01-01"),
                        "booking.bookingdates.checkout",equalTo("2019-01-01"));












    }
}
