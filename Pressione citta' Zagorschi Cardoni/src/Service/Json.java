package Service;

import Model.Pressure;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Float.parseFloat;

public class Json   {
    String city;
    float pressure;
    Pressure objectPressure = new Pressure();
    Gson gson = new Gson();
    public Json(){}
    public String getPressure(String info){
        //
        JsonObject jsonObject = new JsonParser().parse(info).getAsJsonObject();
        pressure = parseFloat(jsonObject.getAsJsonObject("main").get("pressure").getAsString());
        city = jsonObject.get("name").getAsString();
        objectPressure.value=pressure;
        objectPressure.nameCity=city;
        //
        try {
            FileWriter writer = new FileWriter("Output.json");
            new Gson().toJson(jsonObject, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "AAAAAAAAAAAAAAA";
    }
}
