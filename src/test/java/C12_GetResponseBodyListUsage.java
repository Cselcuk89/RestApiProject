import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class C12_GetResponseBodyListUsage {
    /*
    * send get request to http://dummy.restapiexample.com/api/v1/employees
    * verify the following
           * status code is 200
           * content type is application/json
           * total employee is 24
           * one of the employee name is "Ashton Cox"
           * some ages are 61,21,35
     */
    // create endpoint and request body
    @Test
    public void test01(){
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        //create expected data
        //send request and store response
        Response response = given()
                .when()
                .get(url);
        //response.prettyPrint();
        //assertions
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id",hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,21,35));
    }
}
