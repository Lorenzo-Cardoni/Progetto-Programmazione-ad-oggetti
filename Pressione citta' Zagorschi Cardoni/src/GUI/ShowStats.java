package GUI;

import Filters.FilterPressureCustomized;
import Model.Pressure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ShowStats implements ActionListener {

    private String cityName;
    private String startDate;
    private String endDate;
    private Vector<Pressure> pressures;

    private FilterPressureCustomized filter;

    public ShowStats(String name, String date1, String date2){
        this.cityName = name;
        this.startDate = date1;
        this.endDate = date2;

        filter = new FilterPressureCustomized(this.startDate, this.endDate, this.cityName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Le statistiche della pressione nella citta' "+this.cityName+" sono:\n"
                +this.filter.filtersPressure(this.pressures));
    }
}
