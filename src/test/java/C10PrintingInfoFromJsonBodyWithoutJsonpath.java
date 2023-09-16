import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10PrintingInfoFromJsonBodyWithoutJsonpath {
    @Test
    public void method01(){
        JSONObject personalInfo = new JSONObject();

        JSONObject address = new JSONObject();
        address.put("streetAddress","naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");



        JSONObject cellPhone = new JSONObject();
        cellPhone.put("type","iPhone");
        cellPhone.put("number","0123-4567-8888");

        JSONObject homePhone = new JSONObject();
        homePhone.put("type" ,"home");
        homePhone.put("number","0123-4567-8910");
        JSONArray phoneInfo = new JSONArray();
        phoneInfo.put(cellPhone);
        phoneInfo.put(homePhone);

        personalInfo.put("firstName","John");
        personalInfo.put("lastName","Doe");
        personalInfo.put("age",26);
        personalInfo.put("address",address);
        personalInfo.put("phoneNumbers",phoneInfo);

        // printing info that belongs to json object without using jsonpath
        System.out.println("firstname : " + personalInfo.get("firstName"));
        System.out.println("lastname : " + personalInfo.get("lastName"));
        System.out.println("street name : " +
                personalInfo.getJSONObject("address").get("streetAddress"));
        System.out.println("cellphone no : " + personalInfo.getJSONArray("phoneNumbers")
                                                           .getJSONObject(0)
                                                           .get("number"));

    }
}
