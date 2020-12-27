import Service.Api;
import Service.Json;

public class Main {
    public static void main(String[] args) {
        Api api=new Api();
        Json json=new Json();
        json.parseInfo(api.callApi("Pesaro"));
        System.out.print("Hello afewqgadv ");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
