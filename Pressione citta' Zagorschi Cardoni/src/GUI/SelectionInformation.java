package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SelectionInformation extends JFrame {

    public SelectionInformation(){

        /**
         * Imposta la dimensione della finestra.
         */
        setSize(400, 400);

        /**
         *  Specifica che la chiusura della finestra deve far terminare il programma.
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Specifica che la finestra deve essere centrata.
         */
        setLocationRelativeTo(null);

        JButton current_pressure = new JButton("Current pressure");
        current_pressure.setBounds(10,80,80,25);
        current_pressure.addActionListener(new ShowInformation());
        add(current_pressure);

        JButton statsPressure = new JButton("Stats of pressure");
        statsPressure.setBounds(20,80,80,25);
        statsPressure.addActionListener(new SelectionPeriod());
        add(statsPressure);

        /**
         * Visualizza la finestra.
         */
        setVisible(true);

    }
}
