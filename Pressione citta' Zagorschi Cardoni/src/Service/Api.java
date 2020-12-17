package Service;

public class Api {
    static string apiKey="";
    string url = "" + apiKey;
    string cityName;
    public Api(){};
    public Api(string cityName){
        this.cityName=cityName;
    }
}
