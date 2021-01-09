package Service;

import Database.WriteFile;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class JsonParse {
    String pressure;
    String city;
    JSONObject tempJsonObject, jsonObject;
    WriteFile wr;

    /**
     * Questo metodo estrae dalla stringa info (formattata in Json) inserendoli in un oggetto JSONObject
     * In seguito tramite l'oggetto WriteFile salva i dati ottenuti
     * @param info Stringa contenente i dati della chiamata api in formato Json
     */
    public void parseJsonString(String info){
        try {
            tempJsonObject = (JSONObject) JSONValue.parseWithException(info);//main pressure
            JSONObject mainJson = (JSONObject) tempJsonObject.get("main");
            pressure = mainJson.get("pressure").toString();
            city = tempJsonObject.get("name").toString();
            jsonObject = new JSONObject();
            jsonObject.put("city",city.toLowerCase(Locale.ROOT));
            jsonObject.put("pressure",pressure);
            jsonObject.put("date", LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).toString()); //Tronca la data ricevuta da LocalDateTime.now() eliminando millisecondi, secondi e minuti
            wr = new WriteFile();
            wr.saveData(jsonObject);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        }
    /**
     * get del valore della pressione pressure
     */
    public String getPressure(){
        return pressure;
    }
}
