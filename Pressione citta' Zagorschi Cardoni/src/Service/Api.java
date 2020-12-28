package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {
    /**
     * Costruttore
     */
    public Api() {
    }
    /**
     * Dichiarazione variabili e oggetti
     *
     * @param city
     * @return
     */
    String cityName = "";
    HttpURLConnection con;
    String data = "";
    static String apiKey = "&appid=39b2f77fcfc40aa96026fc4d80eb9bb0";

    /**
     * Chiamata api Get con parametro nome citta', ritorna una stringa contenente dati formattati in Json
     *
     * @param city
     * @return
     */
    public void callApi(String city) {
        this.cityName = "q=" + city;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?"+cityName+apiKey);
            con = (HttpURLConnection) url.openConnection();
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    data+=inputLine;
                in.close();
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        /*
        try {
            String url = "http://api.openweathermap.org/data/2.5/weather?" + cityName + apiKey;
            URLConnection openConnection = null;
            openConnection = new URL(url).openConnection();
            InputStream in = openConnection.getInputStream();
            String data = "";
            String line = "";
            try {
                InputStreamReader inR = new InputStreamReader(in);
                BufferedReader buf = new BufferedReader(inR);
                while ((line = buf.readLine()) != null) {
                    data += line;
                }
            } finally {
                in.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        */
        Json json = new Json();
        json.parseJsonString(data);
    }
}