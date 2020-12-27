package Service;

import Model.Pressure;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import static java.lang.Float.parseFloat;

public class Json   {
    /**
     *     dichiarazione variabili/oggetti
     */
    private LocalDateTime date;
    String city;
    float pressure;
    Pressure objectPressure = new Pressure();

    /**
     * Costruttore
     */
    public Json(){}

    /**
     * crea un oggetto Json e lo riempie con informazioni utili
     * stampa su file le informazioni relative alla pressione
     * @param info
     * @return
     */
    public void parseInfo(String info){
        //
        JsonObject jsonObject = new JsonObject();
        JsonObject tempJsonObject = new JsonParser().parse(info).getAsJsonObject();
        //
        pressure = parseFloat(tempJsonObject.getAsJsonObject("main").get("pressure").getAsString());
        city = tempJsonObject.get("name").getAsString();
        date = LocalDateTime.now();
        //
        objectPressure.value=pressure;
        objectPressure.nameCity=city;
        objectPressure.date=date;
        //
        jsonObject.addProperty("city", city);
        jsonObject.addProperty("pressure", pressure);
        jsonObject.addProperty("date" , date.toString());
        //


        try(FileWriter fw = new FileWriter("Output.json", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            fw.write("\n");
            new Gson().toJson(jsonObject, fw);
            //out.println("the text");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
