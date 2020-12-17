package Service;

public class Api {
    static String apiKey="39b2f77fcfc40aa96026fc4d80eb9bb0";
    String url = "http://api.openweathermap.org/data/2.5/weather?id=2172797&appid=" + apiKey;
    String cityName;
    public Api(){}
    public Api(String cityName){
        this.cityName=cityName;
    }
}
