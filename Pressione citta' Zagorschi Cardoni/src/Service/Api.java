package Service;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Api {
    public Api() throws MalformedURLException {}
    public Api(String cityName) throws MalformedURLException {
        this.cityName=cityName;
    }
    String cityName;
    public boolean done;
    static String apiKey="39b2f77fcfc40aa96026fc4d80eb9bb0";
    URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=2172797&appid=" + apiKey);
    HttpURLConnection con;
    {
        try {
            con = (HttpURLConnection) url.openConnection();
            done=true;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
