package Service;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

public class Json   {
    String pressure, city;
    public Json(){}
    public String getPressure(String info){
        JsonObject jsonObject = new JsonParser().parse(info).getAsJsonObject();
        pressure = jsonObject.getAsJsonObject("main").get("pressure").getAsString();
        city = jsonObject.get("name").getAsString();
        return "Citta': " + city + " Pressione: " + pressure;
    }
}
