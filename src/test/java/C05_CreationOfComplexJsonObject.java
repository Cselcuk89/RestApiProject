import org.json.JSONObject;
import org.junit.Test;

public class C05_CreationOfComplexJsonObject {
    @Test
    public void test01(){
        /*
        create below complex json object and print it on the console

           {
            "firstname":"Jim",
            "additionalneeds":"Breakfast",
            "bookingdates":{
            "checkin":"2018-01-01",
            "checkout":"2019-01-01"
            },
            "totalprice":111,
            "depositpaid":true,
            "lastname":"Brown"
            }
         */
        // first create inner json object
        JSONObject dateJsonObject = new JSONObject();
        dateJsonObject.put("checkin","2018-01-01");
        dateJsonObject.put("checkout","2019-01-01");

        //then create outer json object and insert inner json object into it
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname","Jim");
        requestBody.put("lastname","Brown");
        requestBody.put("totalprice",111);
        requestBody.put("depositpaid",true);
        requestBody.put("bookingdates",dateJsonObject);
        requestBody.put("additionalneeds","Breakfast");
        System.out.println(requestBody);
    }

}
