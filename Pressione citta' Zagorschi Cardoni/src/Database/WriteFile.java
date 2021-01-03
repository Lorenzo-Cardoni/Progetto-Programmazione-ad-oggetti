package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteFile {
    /**
     * @param city Stringa contenente il nome della citta' da inserire nel file pressureData.txt
     * @param pressure Stringa contenente la pressione da inserire nel file pressureData.txt
     * @param dateTime Stringa contenente la data da inserire nel file pressureData.txt
     */
    public void saveData(String city, String pressure, LocalDateTime dateTime) {
        Boolean fileExist = false;
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

        FileWriter fr = null;
        try {
            fr = new FileWriter("pressureData.txt", true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(data);
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}