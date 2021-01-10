package GUI;

import Database.ReadFile;
import Model.Pressure;
import Service.ApiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * GUI principale a cui l'utente viene chiesto di inserire il nome della citta'.
 */
public class SelectionCity extends JFrame implements ActionListener {

    private SelectionInformation window2;
    private JLabel citylabel;
    private JTextField nameCityText;
    private JButton search;
    private ApiController api = new ApiController();
    private ReadFile readFile = new ReadFile();

    /**
     * Costruttore della classe SelectionCity
     * @param title
     */
    public SelectionCity(String title) {

        /**
         *  crea il JFrame
         *
         */
        super(title);
        /**
         * Imposta la dimensione della finestra.
         */
        this.setSize(500, 100);
        /**
         *  Specifica che la chiusura della finestra deve far terminare il programma.
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Specifica che la finestra deve essere centrata.
         */
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        this.add(panel);


        citylabel = new JLabel("Name city ");
        panel.add(citylabel);

        nameCityText = new JTextField(20);
        panel.add(nameCityText);

        search = new JButton("Search");
        search.setBounds(10,80,80,25);
        search.addActionListener(this);
        panel.add(search);


        /**
         * Visualizza la finestra.
         */
        this.setVisible(true);

    }

    /**
     * Metodo relativo al button 'Search' che apre una finestra contenente altre istruzioni.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String cityName = nameCityText.getText();
        if(nameCityText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Insert the name of city");
        }
        else
        {
            try {

                String support = this.api.callApi(cityName);
                if (support != "ERROR") {

                    this.setVisible(false);

                    this.window2 = new SelectionInformation(cityName, cityName,support);
                    window2.setVisible(true);

                } else
                    JOptionPane.showMessageDialog(null, "ERROR\nCity not found");

            } catch (Exception ecc) {
                System.out.println("ERROR.");
                System.out.println("MESSAGGE: " + ecc.getMessage());
            }
        }

    }
}
