package Service;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {
    public Api(){}
    public Api(String cityName){
        this.cityName=cityName;
    }
    String cityName;
    static String apiKey="39b2f77fcfc40aa96026fc4d80eb9bb0";
    URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=2172797&appid=" + apiKey);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
}
