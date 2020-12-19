package Service;
import org.json.*;
import java.io.IOException;


public class Json   {
    public Json(){}
    String data="";
    public String getPressure(String info){
        data=info;
        JSONObject obj = new JSONObject(data);
        JSONObject oTime = obj.getJSONObject ("pressure");
        return oTime.toString();
    }
}
