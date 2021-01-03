package Database;

import Model.Pressure;
import Utils.ConvertHashMapToVector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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

    /**
     * Il metodo readFile legge i dati dal file pressureData.txt, li inserisce in un hashmap per poi restituire un vettore contenente oggetti Pressure attraverso l'oggetto convert
     * @param cityName Stringa usata per filtrare i dati letti in base alla citta'
     * @return Vettore oggetti Pressure
     */
    public Vector<Pressure> readFile(String cityName){
        hashMap = new HashMap<>();
        String line;
        String[] data;
        try (BufferedReader br = new BufferedReader(new FileReader("pressureData.txt"))) {
            while ((line = br.readLine()) != null) {
                /**
                 * La riga letta dal file viene splittata in 3 parti: Nome citta', data, valore pressione
                 */
                data = line.split(";");
                if(data[0].equals(cityName)){
                    hashMap.put((data[0]+";"+data[1]), data[2]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convert.convertHashMapToVector(hashMap);
    }
}
