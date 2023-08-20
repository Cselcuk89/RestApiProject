
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C3_GetRequest_VerifyingResponseValues {
    /*
    send get request to https://restful-booker.herokuapp.com/booking/10 and
    verify that status code is 200
                content type is application/json; charset=utf-8
                server header value is cowboy
                status line is HTTP/1.1 200 OK
                response time is less than 5 seconds

     */
    @Test
    public void test02(){
        //1. step
        String url = "https://restful-booker.herokuapp.com/booking/10";
        //2.step
        //3.step
        Response response = given().when().get(url);
        response.prettyPrint();
        //4.step==> assertion
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")

                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");
    }





}
