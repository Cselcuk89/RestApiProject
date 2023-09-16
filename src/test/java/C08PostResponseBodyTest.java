import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08PostResponseBodyTest {
    @Test
    public void test01(){
        /*
        -go to https://jsonplaceholder.typicode.com/posts
        -send post request with the following json body
               {
                    "title":"API",
                    "body":"API ogrenmek ne guzel",
                    "userId":10,
                    }
        - verify the response has the following:
                -status code is 201
                -content type is application/json
                - response body has the following:
                       -"title" is "API"
                       -"userId" value is less than 100
                       -response body contains "API" word



         */
        //1.step prepare end point and create request body
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title","API");
        requestBody.put("body","API ogrenmek ne guzel");
        requestBody.put("userId",10);

        //2.step create expected data
        //3.step send post request with the body and store the response
        Response response = given().contentType(ContentType.JSON)
                                    .when().body(requestBody.toString())
                                    .post(url);
        response.prettyPrint();
        //4. step
        response.then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));


    }

}
