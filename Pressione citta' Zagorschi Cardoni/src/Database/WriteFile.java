package Database;

import com.google.gson.JsonObject;
import org.json.simple.JSONArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    public void saveData(JsonObject tempJsonObject) {
        ReadFile fr = new ReadFile();
        JSONArray jsonArray = new JSONArray();
        jsonArray = fr.readFile();
        jsonArray.add(tempJsonObject);
        try {
            PrintWriter file_output = new PrintWriter(new BufferedWriter(new FileWriter("pressureData.txt")));
            file_output.println(jsonArray);
            file_output.close();
            System.out.println("File salvato!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        Boolean fileExist = false;
        tempJsonObject.getAsJsonObject("main").get("pressure").getAsString();
        city = city.toLowerCase(Locale.ROOT); //Converte tutti i caratteri maiuscoli di cityName in minuscoli per evitare errori nella futura fase di lettura.
        File file = new File("pressureData.txt");
        try {
            if (!file.createNewFile()) {
                fileExist = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = "";
        if (fileExist) data += "\n";
        data += city + ";" + dateTime + ";" + pressure + ";";
        try {
            fr = new FileWriter("pressureData.txt", true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(data);
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}