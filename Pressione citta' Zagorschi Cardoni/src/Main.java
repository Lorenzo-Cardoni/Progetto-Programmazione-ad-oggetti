import Service.Api;
import Service.Json;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        Json json = new Json();
        Api api=new Api();
        System.out.println(json.getPressure(api.callApi("Pesaro")));
    }
}
