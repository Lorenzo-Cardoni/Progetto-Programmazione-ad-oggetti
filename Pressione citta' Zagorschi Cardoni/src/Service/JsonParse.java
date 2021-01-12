package Service;

import Database.WriteFile;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class JsonParse {
    private String pressure;
    private String city;
    private JSONObject tempJsonObject, jsonObject;
    private WriteFile wr;

    /**
     * Questo metodo estrae dalla stringa info (formattata in Json) inserendoli in un oggetto JSONObject
     * In seguito tramite l'oggetto WriteFile salva i dati ottenuti
     * @param info Stringa contenente i dati della chiamata api in formato Json
     */
    public void parseJsonString(String info){
        try {

            this.tempJsonObject = (JSONObject) JSONValue.parseWithException(info);//main pressure
            JSONObject mainJson = (JSONObject) this.tempJsonObject.get("main");
            this.pressure = mainJson.get("pressure").toString();
            this.city = this.tempJsonObject.get("name").toString();
            this.jsonObject = new JSONObject();
            this.jsonObject.put("city",this.city.toLowerCase(Locale.ROOT));
            this.jsonObject.put("pressure",this.pressure);
            this.jsonObject.put("date", LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).toString()); //Tronca la data ricevuta da LocalDateTime.now() eliminando millisecondi, secondi e minuti
            this.wr = new WriteFile();
            this.wr.saveData(jsonObject);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        }
    /**
     * get del valore della pressione pressure
     */
    public String getPressure(){
        return this.pressure;
    }
}
