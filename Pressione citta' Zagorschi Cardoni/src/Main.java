import Service.Api;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        try {
            Api api=new Api();
            System.out.println(api.callApi("Pesaro"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
