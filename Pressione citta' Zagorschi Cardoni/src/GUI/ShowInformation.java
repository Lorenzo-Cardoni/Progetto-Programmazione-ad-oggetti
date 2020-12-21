package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowInformation implements ActionListener {
    private String cityName;
    private float pressure = 0;

    public ShowInformation(String name){
        this.cityName = name;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"La pressione nella citta' "+this.cityName+" e': "+this.pressure+"Pa");
    }
}
