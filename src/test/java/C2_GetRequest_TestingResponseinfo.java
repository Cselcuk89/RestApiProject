import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C2_GetRequest_TestingResponseinfo {
    /*
    send get request to https://restful-booker.herokuapp.com/booking/10 and
    print that status code is 200
                content type is application/json; charset=utf-8
                server header value is cowboy
                status line is HTTP/1.1 200 OK
                response time is less than 5 seconds

     */
     @Test
    public void test01(){
         //1. step
         String url = "https://restful-booker.herokuapp.com/booking/10";
         //2.step
         //3.step
         Response response = given().when().get(url);
         System.out.println(response.getBody().toString());
         System.out.println("Status code is : " + response.getStatusCode() +
                            "\nContent type : " + response.getContentType() +
                            "\nServer header value  : " + response.getHeader("Server") +
                            "\nStatus line : " + response.getStatusLine()+
                            "\nResponse time : " + response.getTime() + "ms");

     }
}
