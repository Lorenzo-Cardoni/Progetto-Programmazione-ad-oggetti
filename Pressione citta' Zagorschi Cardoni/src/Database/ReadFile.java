package Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {

    public ReadFile(){}
    Map<String, String> hashMap;
    public Map readFile(String cityName){
        hashMap = new HashMap<>();
        String line;
        String[] data;
        try (BufferedReader br = new BufferedReader(new FileReader("pressureData.txt"))) {
            while ((line = br.readLine()) != null) {
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
        return hashMap;
    }
}
