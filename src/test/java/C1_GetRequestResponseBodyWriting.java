import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C1_GetRequestResponseBodyWriting {
    /*
    Send get request to https://restful-booker.herokuapp.com/booking/10 url and print the response.
     */

    @Test
    public void get01(){
        // prepare request body if necessary and end point
        String url = "https://restful-booker.herokuapp.com/booking/10";
        // prepare expected data
        // send request and store the response returning from server
        Response response = given().when().get(url);//this will send request to server and store the response from server into response object
        response.prettyPrint();
        // Assertion



    }
}
