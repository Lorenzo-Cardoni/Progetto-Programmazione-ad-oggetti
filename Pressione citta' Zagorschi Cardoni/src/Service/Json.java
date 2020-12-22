package Service;

import Model.Pressure;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static java.lang.Float.parseFloat;

public class Json   {
    String city;
    float pressure;
    Pressure objectPressure = new Pressure();
    Gson gson=new Gson();
    public Json(){}
    public String getPressure(String info){
        JsonObject jsonObject = new JsonParser().parse(info).getAsJsonObject();
        pressure =parseFloat(jsonObject.getAsJsonObject("main").get("pressure").getAsString());
        city = jsonObject.get("name").getAsString();
        objectPressure.value=pressure;
        objectPressure.nameCity=city;
        //gson.toJson(objectPressure, new FileWriter(filePath));
        return "Citta': " + city + " Pressione: " + pressure;
    }
}
