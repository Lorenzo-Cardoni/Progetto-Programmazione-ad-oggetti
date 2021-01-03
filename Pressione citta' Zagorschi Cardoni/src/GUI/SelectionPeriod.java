package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exception.*;

/**
 * GUI con quattro button relativi al periodo a quale si vuole fare riferimento.
 */
public class SelectionPeriod extends JFrame implements ActionListener {

    private String cityName;
    private SelectionDate window5;
    private JPanel panel;

    /**
     * Costruttore della classe SelectionPeriod
     *
     * @param title nome della finestra.
     * @param name nome della citta'.
     */
    public SelectionPeriod(String title, String name){

        super(title);
        /**
         * Imposta la dimensione della finestra.
         */
        this.setSize(400, 150);


        /**
         * Specifica che la finestra deve essere centrata.
         */
        this.setLocationRelativeTo(null);

        this.panel = new JPanel();
        this.add(panel);

        this.cityName = name;

        JButton daily = new JButton("This day");
        daily.addActionListener(new ShowStatsStandard(0,this.cityName));
        panel.add(daily);

        JButton weekly = new JButton("This week");
        weekly.addActionListener(new ShowStatsStandard(7,this.cityName));
        panel.add(weekly);

        JButton monthly = new JButton("This month");
        monthly.addActionListener(new ShowStatsStandard(31,this.cityName));
        panel.add(monthly);

        JButton customPressure = new JButton("Custom Pressure");
        customPressure.addActionListener(this);
        panel.add(customPressure);

        this.setVisible(false);
    }

    /**
     * Metodo relativo al button 'Custom Pressure' che apre una finestra contenente altre istruzioni.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.window5 = new SelectionDate("Selection date", this.cityName);
        this.window5.setVisible(true);
    }
}
