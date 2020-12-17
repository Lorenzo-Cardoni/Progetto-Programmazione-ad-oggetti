import Service.Api;

import javax.swing.*;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) {
        Api api = null;
        try {
            api = new Api();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(api.done);
        JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");

    }
}
