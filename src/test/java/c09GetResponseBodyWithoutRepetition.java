import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class c09GetResponseBodyWithoutRepetition {
    @Test
    public void test01(){
        /*
        -go to https://restful-booker.herokuapp.com/booking/10
        -send get request
        -verify that the response has the following
             -status code is 200
             -content type is application-json
             -response body has the following:
                  -"firstname" is susan
                  -"lastname" is Jackson
                  -"totalPrice" is less than 100
                  -"depositPaid" is false
                  -"additionalNeeds" is not null
         */
        //1.step prepare the endpoint and create the request body
        String url = " https://restful-booker.herokuapp.com/booking/10";
        //2.step create expected data
        //3.step send get request and store the response
        Response response = given().when().get(url);
        //4.step assertion
        response.prettyPrint();
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Susan"),
                        "lastname",equalTo("Brown"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(true),
                        "additionalneeds",notNullValue());
    }
}
