package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiController {
    public ApiController() {
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
    JsonParse json = new JsonParse();
    static String apiKey = "&appid=39b2f77fcfc40aa96026fc4d80eb9bb0";
    public String callApi(String city) {
        Boolean cityExist=false;
        this.cityName = "q=" + city;
         try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?"+cityName+apiKey);
            con = (HttpURLConnection) url.openConnection();
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                cityExist=true;
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

         if(cityExist){
             json.parseJsonString(data);
         }

         if(cityExist){
             System.out.println(json.getPressure());
             return json.getPressure();
         }else {
             System.out.println("ERROR");
             return "ERROR";
         }
    }
}