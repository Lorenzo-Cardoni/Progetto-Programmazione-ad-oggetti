package GUI;


import Database.ReadFile;
import Filters.FilterPressureStandard;
import Model.Pressure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Classe che mostra le statistiche di un periodo standard.
 *
 */
public class ShowStatsStandard implements ActionListener {

    private String cityName;
    private int days;

    private FilterPressureStandard filter;
    private ReadFile vectorOfPressure = new ReadFile();

    /**
     * Costruttore della classe ShowStatsStandard
     *
     * @param days numero giorni del periodo.
     * @param name nome della citta'.
     */
    public ShowStatsStandard(int days, String name){
        this.cityName = name;
        this.days = days;
        filter = new FilterPressureStandard(this.days, this.vectorOfPressure.readFile(this.cityName) );
    }

    /**
     *  Metodo che mostra le statistiche di un periodo standard.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String message;

        switch (this.days){
            case  0:
                message = " di oggi ";
                break;

            case 7:
                message = " di questa settimana ";
                break;

            case 31 | 30:
                message = " di questo mese ";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.days);
        }

        JOptionPane.showMessageDialog(null,"Le statistiche della pressione nella citta' "+this.cityName+message+" sono:\n"
                +this.filter.filtersPressure());
    }
}
