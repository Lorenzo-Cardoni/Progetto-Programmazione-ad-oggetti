package Service;

import Database.WriteFile;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Json  {
    public void parseJsonString(String info){
        String pressure;
        String city;
        JsonObject tempJsonObject = new JsonParser().parse(info).getAsJsonObject();
        pressure = tempJsonObject.getAsJsonObject("main").get("pressure").getAsString();
        city = tempJsonObject.get("name").getAsString();
        WriteFile wr = new WriteFile();
        wr.saveData(city, pressure, LocalDateTime.now().truncatedTo(ChronoUnit.HOURS));
    }
}
