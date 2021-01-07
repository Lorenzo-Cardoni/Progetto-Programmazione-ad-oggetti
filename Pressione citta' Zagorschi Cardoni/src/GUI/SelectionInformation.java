package GUI;

import Service.ApiController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI a cui all'utente viene chiesto se vuole la pressione attuale della pressione o le
 * statistiche di un determinato periodo.
 */
public class SelectionInformation extends JFrame implements ActionListener {

    private String cityName;
    private float pressureValue;
    private SelectionPeriod window3;
    private JPanel panel1;
    private String valuePressure;

    /**
     * Costruttore della classe SelectionInformation.
     *
     * @param title nome della finestra.
     * @param name nome della citta'.
     */
    public SelectionInformation(String title, String name, String valuePressureApi){

        super(title);

        this.valuePressure = valuePressureApi;
        /**
         * Imposta la dimensione della finestra.
         *
         */
        this.setSize(500, 100);


        /**
         *  Specifica che la chiusura della finestra deve far terminare il programma.
         *
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Specifica che la finestra deve essere centrata.
         */
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        this.add(panel);

        this.cityName = name;

        JButton current_pressure = new JButton("Current pressure");
        current_pressure.addActionListener(new ShowInformation(this.cityName,this.valuePressure));
        panel.add(current_pressure, BorderLayout.WEST);

        JButton statsPressure = new JButton("Stats of pressure");
        statsPressure.addActionListener(this);
        panel.add(statsPressure, BorderLayout.EAST);

        /**
         * Visualizza la finestra.
         *
         */
        setVisible(false);


    }

    /**
     * Metodo relativo al button 'Statss of pressure' che apre una finestra contenente altre istruzioni.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        this.window3 = new SelectionPeriod("Selection period", this.cityName);
        this.window3.setVisible(true);

    }
}
