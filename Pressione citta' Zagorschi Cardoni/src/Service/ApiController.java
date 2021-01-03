package Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class ApiController {
    public ApiController() {
    }
    /**
     * Dichiarazione variabili e oggetti
     *
     * @param city
     * @return
     */
    String cityName;
    HttpURLConnection con;
    String data;
    JsonParse json;
    Boolean cityExist;
    Properties prop=new Properties();
    static String apiKey;
    InputStream is = null;

    public String callApi(String city) {
        try {
            is = new FileInputStream("src/config.editorconfig");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(is);
            apiKey="&appid=" + prop.getProperty("apiKey");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cityName="";
        data="";
        json = new JsonParse();
        cityExist=false;
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