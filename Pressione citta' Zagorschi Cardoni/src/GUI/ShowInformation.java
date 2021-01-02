package GUI;

import Service.ApiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowInformation implements ActionListener {
    private String cityName;
    private ApiController valueOfPressure = new ApiController();

    public ShowInformation(String name){
        this.cityName = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"La pressione nella citta' "+this.cityName+" e': "
                +this.valueOfPressure.callApi(this.cityName)+"Pa");
    }
}
