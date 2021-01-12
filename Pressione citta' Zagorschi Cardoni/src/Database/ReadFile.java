package Database;

import Model.Pressure;
import Utils.ConvertHashMapToVector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class ReadFile {
    /**
     * ReadFile() Costruttore vuoto
     */
    public ReadFile(){}
    /**
     * hashMap Hashmap che conterra' i dati letti dal file
     * convert Oggetto che converte da HashMap a Vettore contenente oggetti Pressure
     */
    private Map<String, String> hashMap;
    private ConvertHashMapToVector convert = new ConvertHashMapToVector();
    private JSONArray jsonArray;

    /**
     * @return Ritorna un JSONArray contenente tutti i dati letti dal file in formato JSON
     */
    public  JSONArray readFile(){
        this.jsonArray=new JSONArray();//JSONArray che conterra' i dati
        try {
            File newFile = new File("pressureData.txt");
            if(newFile.length()>0) { //Legge il file solo nel caso in cui contenga dati, altrimenti il metodo readFile ritorna un JSONArray vuoto
                Scanner file_input = new Scanner(new BufferedReader(new FileReader("pressureData.txt")));
                String str = file_input.nextLine();
                this.jsonArray = (org.json.simple.JSONArray) JSONValue.parseWithException(str); //Parsa stringa letta
                file_input.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this.jsonArray;
    }

    /**]
     * @param tempCityName Stringa usata per filtrare i dati
     * @return Ritorna un Vector<Pressure> contenente i dati letti dal file in base alla citta' passata come parametro
     */
    public  Vector<Pressure> readFile(String tempCityName){
        tempCityName=tempCityName.toLowerCase(Locale.ROOT);
        this.jsonArray = new JSONArray();
        this.hashMap = new HashMap<>();
        String tempCity, tempDate, tempPressure;
        try {
            Scanner file_input = new Scanner(new BufferedReader(new FileReader("pressureData.txt")));
            String str = file_input.nextLine();
            this.jsonArray = (JSONArray)JSONValue.parseWithException(str);//Parsa stringa letta
            file_input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Riempimento HashMap
        for(int i=0;i<this.jsonArray.size();i++){
            JSONObject job = new JSONObject(); //job viene resettato ad ogni iterazione del ciclo for
            job = (JSONObject) this.jsonArray.get(i);
            tempCity = job.get("city").toString();
            if(tempCity.equals(tempCityName)){ //Controlla se la citta' letta corrisponde al parametro iniziale tempCityName
                tempDate = job.get("date").toString();
                tempPressure = job.get("pressure").toString();
                this.hashMap.put(tempCity+";"+tempDate,tempPressure); //hashMap viene riempito
            }
        }
        return this.convert.convertHashMapToVector(this.hashMap);
    }
}
