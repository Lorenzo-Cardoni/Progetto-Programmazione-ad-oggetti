package Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public ReadFile(){}
    public void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("pressureData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
