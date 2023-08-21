import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C07GetResponseBodyTest {
    @Test
    public void test01(){
        /*
        go to https://jsonplaceholder.typicode.com/posts/44
        send get request
        verify that the response has the following:
            -status code is 200
            -content type is Aplication.JSON
            -response body has userId that is 5
            -response body has the title that is "optio dolor molestias sit"
         */

        //prepare end point and request body
        String url = "https://jsonplaceholder.typicode.com/posts/44";
        // create expected data
        //send request and store the response
        Response response = given().when().get(url);
        response.prettyPrint();
        //assertion
        response.then().assertThat()
                       .statusCode(200)
                       .contentType(ContentType.JSON)
                       .body("userId", Matchers.equalTo(5))
                       .body("title",CoreMatchers.equalTo("optio dolor molestias sit"));
    }
}
