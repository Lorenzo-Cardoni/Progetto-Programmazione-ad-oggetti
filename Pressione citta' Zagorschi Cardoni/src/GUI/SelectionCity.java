package GUI;

import Model.Pressure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SelectionCity extends JFrame implements ActionListener {

    private SelectionInformation window2;
    private JLabel citylabel;
    private JTextField nameCityText;
    private JButton search;
    private Map<String, Vector<Pressure>> pressures = new HashMap<String, Vector<Pressure>>();

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


        /**
         * Inizializzo la casella di input dove verra' inserito il nome
         * della citta'.
         *
         */
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


    @Override
    public void actionPerformed(ActionEvent e) {

        String cityName = nameCityText.getText();
        //if(this.pressures.containsKey(cityName)) {

            this.setVisible(false);

            this.window2 = new SelectionInformation("Selection information", cityName);
            window2.setVisible(true);
        //}

       //JOptionPane.showMessageDialog(null,"City not found");
    }
}
