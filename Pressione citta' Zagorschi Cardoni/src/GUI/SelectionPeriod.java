package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionPeriod extends JFrame implements ActionListener {

    private String cityName;
    private SelectionDate window5;
    private JPanel panel;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        this.window5 = new SelectionDate("Selection date", this.cityName);
        this.window5.setVisible(true);
    }
}
