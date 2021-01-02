package Service;

import Database.WriteFile;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.LocalDateTime;

public class JsonParse {
    String pressure;
    String city;
    public void parseJsonString(String info){
        JsonObject tempJsonObject = new JsonParser().parse(info).getAsJsonObject();
        pressure = tempJsonObject.getAsJsonObject("main").get("pressure").getAsString();
        city = tempJsonObject.get("name").getAsString();
        WriteFile wr = new WriteFile();
        wr.saveData(city, pressure, LocalDateTime.now());
    }
    public String getPressure(){
        return pressure;
    }
}
