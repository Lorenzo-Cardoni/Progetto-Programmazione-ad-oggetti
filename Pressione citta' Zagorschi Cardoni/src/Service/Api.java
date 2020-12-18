package Service;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Api {
    public Api() throws MalformedURLException {}
    //Variables
    String cityName="q=";
    float pression;
    public boolean done;
    static String apiKey="&appid=39b2f77fcfc40aa96026fc4d80eb9bb0";
    URL url = null;
    HttpURLConnection con;

    //Methods

    //Call api knowing city name
    public boolean callApi(String cityName){
        this.cityName += cityName;
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?"+cityName+apiKey);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            con = (HttpURLConnection) url.openConnection();
            done=true;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return done;
    }

    //Set city name
    public void setCityname(String cityName){
         this.cityName=cityName;
    }
}
