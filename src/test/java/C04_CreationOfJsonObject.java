import org.json.JSONObject;
import org.junit.Test;

public class C04_CreationOfJsonObject {
    @Test
    public void test01(){
        /*
        create below json object and print it on the console
        {
          "title":"Ahmet",
          "body":"Merhaba",
          "userId":1
        }
         */
        JSONObject obj1 = new JSONObject();
        obj1.put("title","Ahmet");
        obj1.put("body","Merhaba");
        obj1.put("userId",1);
        System.out.println(obj1);

    }
}
