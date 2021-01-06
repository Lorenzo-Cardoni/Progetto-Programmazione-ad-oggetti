package Database;

import Model.Pressure;
import Utils.ConvertHashMapToVector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {
    /**
     * ReadFile() Costruttore vuoto
     */
    public ReadFile(){}
    /**
     * @param hashMap Hashmap che conterra' i dati letti dal file
     * @param convert Oggetto che converte da HashMap a Vettore contenente oggetti Pressure
     */
    Map<String, String> hashMap;
    ConvertHashMapToVector convert = new ConvertHashMapToVector();

    JSONArray jsonArray;
    public  JSONArray readFile(){
        jsonArray=new JSONArray();
        try {
            Scanner file_input = new Scanner(new BufferedReader(new FileReader("pressureData.txt")));
            String str = file_input.nextLine();
            jsonArray = (org.json.simple.JSONArray)JSONValue.parseWithException(str);
            System.out.println("JSONArray letto");
            file_input.close();
        } catch (ParseException | IOException var7) {
            var7.printStackTrace();
        } catch (Exception var8) {
            var8.printStackTrace();
        }
        return jsonArray;
    }
    public  Vector<Pressure> readFile(String tempCityName){
        tempCityName=tempCityName.toLowerCase(Locale.ROOT);
        jsonArray=new JSONArray();
        hashMap = new HashMap<>();
        String tempCity, tempDate, tempPressure;
        try {
            Scanner file_input = new Scanner(new BufferedReader(new FileReader("pressureData.txt")));
            String str = file_input.nextLine();
            jsonArray = (JSONArray)JSONValue.parseWithException(str);
            System.out.println("JSONArray letto");
            file_input.close();
        } catch (ParseException | IOException var7) {
            var7.printStackTrace();
        } catch (Exception var8) {
            var8.printStackTrace();
        }
        for(int i=0;i<jsonArray.size();i++){
            JSONObject job = new JSONObject();
            job = (JSONObject) jsonArray.get(i);
            tempCity = job.get("city").toString();
            if(tempCity.equals(tempCityName)){
                tempDate = job.get("date").toString();
                tempPressure = job.get("pressure").toString();
                hashMap.put(tempCity+";"+tempDate,tempPressure);
            }
        }
        return convert.convertHashMapToVector(hashMap);
    }
    /**
     * Il metodo readFile legge i dati dal file pressureData.txt, li inserisce in un hashmap per poi restituire un vettore contenente oggetti Pressure attraverso l'oggetto convert
     * @param cityName Stringa usata per filtrare i dati letti in base alla citta'
     * @return Vettore oggetti Pressure
     */
    /*
    public Vector<Pressure> readFile(String cityName){
        cityName=cityName.toLowerCase(Locale.ROOT); //Converte tutti i caratteri maiuscoli di cityName in minuscoli per evitare errori di lettura.
        hashMap = new HashMap<>();
        String line;
        String[] data;
        try (BufferedReader br = new BufferedReader(new FileReader("pressureData.txt"))) {
            while ((line = br.readLine()) != null) {
                data = line.split(";"); //La riga letta dal file viene splittata in 3 parti: Nome citta', data, valore pressione
                if(data[0].equals(cityName)){ //Controllo per filtrare la citta' di interesse
                    hashMap.put((data[0]+";"+data[1]), data[2]); //Popola hashMap
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convert.convertHashMapToVector(hashMap); //Ritorna un vettore di oggetti Pressure richiamando una funzione dell'oggetto convert, che converte l'hashmap contenente i dati
    }

     */
}
