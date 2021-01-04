package Service;

import Database.WriteFile;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class JsonParse {
    String pressure;
    String city;
    JsonObject tempJsonObject;
    WriteFile wr;

    /**
     * Questo metodo estrae dalla stringa info (formattata in Json) inserendoli in un oggetto JsonObject
     * In seguito tramite l'oggetto WriteFile salva i dati ottenuti
     * @param info Stringa contenente i dati della chiamata api in formato Json
     */
    public void parseJsonString(String info){
        tempJsonObject = new JsonParser().parse(info).getAsJsonObject();
        pressure = tempJsonObject.getAsJsonObject("main").get("pressure").getAsString();
        city = tempJsonObject.get("name").getAsString();
        wr = new WriteFile();
        wr.saveData(city, pressure, LocalDateTime.now().truncatedTo(ChronoUnit.HOURS)); //Tronca la data ricevuta da LocalDateTime.now() eliminando millisecondi, secondi e minuti
    }
    /**
     * get del valore della pressione pressure
     */
    public String getPressure(){
        return pressure;
    }
}
