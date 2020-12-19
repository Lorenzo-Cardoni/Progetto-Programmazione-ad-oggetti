package Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;

public class Api {
    public Api() {}
    //Variables
    String cityName;
    float pression;
    public boolean done;
    static String apiKey="&appid=39b2f77fcfc40aa96026fc4d80eb9bb0";
    URL url = null;
    HttpURLConnection con;
    String data="";
    //Methods

    //Call api knowing city name
    public String callApi(String city){
        this.cityName = "q=" + city;
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?"+cityName+apiKey);
            con = (HttpURLConnection) url.openConnection();
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = con.getInputStream();
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
        return data;
    }

    //Set city name
    public void setCityname(String cityName){
         this.cityName=cityName;
    }
}
