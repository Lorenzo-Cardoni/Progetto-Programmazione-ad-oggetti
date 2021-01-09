package Database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class WriteFile {
    /**
     * metodo saveData salva i dati ricevuti dalla chiamata api nel file "pressureData.txt"
     * @param tempJsonObject JSONObject contenente i dati da salvare
     */
    public void saveData(JSONObject tempJsonObject) {
        Boolean flag = false;
        ReadFile fr = new ReadFile();
        JSONArray jsonArray = new JSONArray();
        jsonArray = fr.readFile(); //Il file viene letto e i dati salvati in un JSONArray
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject job = new JSONObject();
            job = (JSONObject) jsonArray.get(i);
            if (job.get("city").toString().equals(tempJsonObject.get("city").toString())) {
                if (job.get("date").toString().equals(tempJsonObject.get("date").toString())) {
                    jsonArray.set(i, tempJsonObject); //Nel caso in cui i dati (letti dal file a confronto con dati dalla chiamata api) abbiano stessi valori "city" e "date" il valore della pressione viene aggiornato
                    flag = true;// Flag viene utilizzata in seguito per sapere se i dati sono stati aggiornati
                }
            }
        }
        if (!flag) jsonArray.add(tempJsonObject);
        try {
            PrintWriter file_output = new PrintWriter(new BufferedWriter(new FileWriter("pressureData.txt")));
            file_output.println(jsonArray);
            file_output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}