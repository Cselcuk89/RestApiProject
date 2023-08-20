import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C06_Put_AssertionOfResponseBody {
    @Test
    public void test01(){
        /*
            When we send put request to https://jsonplaceholder.typicode.com/posts/70 url using below json object
            {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
            }
            verify that response of status code is 200
                        content type is application/json; charset=utf-8
                        server header value is cloudflare
                        status line is HTTP/1.1 200 OK

         */

        //1.step==> prepare end point and request body
        String url = "https://jsonplaceholder.typicode.com/posts/70 ";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",10);
        requestBody.put("id",70);
        //2.step==> create expected body
        //3. step==> send put request and store the response
        Response response = given().contentType(ContentType.JSON)
                                   .when().body(requestBody.toString())
                                   .put(url);
        response.prettyPrint();
        //4.step ==> assertions
        response.then().assertThat()
                       .statusCode(200)
                       .contentType("application/json; charset=utf-8")
                       .statusLine("HTTP/1.1 200 OK")
                       .header("Server","cloudflare");
    }
}
