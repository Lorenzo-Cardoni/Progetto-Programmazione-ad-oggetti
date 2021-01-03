package GUI;

import Service.ApiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI tramite cui viene mostrata la pressione attuale di una determinata citta'.
 */
public class ShowInformation implements ActionListener {
    private String cityName;
    private ApiController valueOfPressure = new ApiController();

    /**
     * Costruttore della classe ShowInformation
     * @param name nome della citta'.
     */
    public ShowInformation(String name){
        this.cityName = name;
    }

    /**
     * Metodo che mostra la pressione di una determinata citta'.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"La pressione nella citta' "+this.cityName+" e': "
                +this.valueOfPressure.callApi(this.cityName)+"Pa");
    }
}
