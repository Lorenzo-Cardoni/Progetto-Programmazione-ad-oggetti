package GUI;

import Database.ReadFile;
import Filters.FilterPressureCustomized;
import Exception.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI a cui all'utente viene chiesto di inserire il periodo personalizzato
 * e ritorna le statistiche di quel periodo.
 *
 */
public class SelectionDate extends JFrame implements ActionListener {
    private String cityName;
    private JPanel panel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JTextField startDateText;
    private JTextField endDateText;
    private JButton calculate;

    private FilterPressureCustomized filter;
    private ReadFile vectorOfPressure = new ReadFile();

    /**
     * Costruttore della classe SelectionDate.
     *
     * @param title nome della finestra.
     * @param name nome della citta'.
     */
    public SelectionDate(String title, String name) {

        super(title);
        /**
         * Imposta la dimensione della finestra.
         */
        setSize(600, 150);

        /**
         * Specifica che la finestra deve essere centrata.
         */
        setLocationRelativeTo(null);

        panel = new JPanel();
        this.add(panel);

        this.cityName = name;

        startDateLabel = new JLabel("Period start date");
        startDateLabel.setBounds(10,20,80,25);
        panel.add(startDateLabel);

        startDateText = new JTextField(20);
        startDateText.setBounds(100,20,80,25);
        panel.add(startDateText);

        endDateLabel = new JLabel("Period end date");
        endDateLabel.setBounds(10,40,80,25);
        panel.add(endDateLabel);

        endDateText = new JTextField(20);
        endDateText.setBounds(100,40,80,25);
        panel.add(endDateText);

        calculate = new JButton("Search");
        calculate.setBounds(10,80,80,25);
        calculate.addActionListener(this);
        panel.add(calculate);

        this.setVisible(false);

    }

    /**
     * Metodo relativo al button 'Search' che apre una finestra contenente le statistiche.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            this.filter = new FilterPressureCustomized(startDateText.getText(), endDateText.getText(), vectorOfPressure.readFile(this.cityName));
        } catch (PressureException pressureException) {
            System.out.println();
        }

        if(this.filter != null)
        {
            JOptionPane.showMessageDialog(null, "Le statistiche della pressione nella citta' " + this.cityName + " sono:\n"
                    + this.filter.filtersPressure());
        }
    }

}
