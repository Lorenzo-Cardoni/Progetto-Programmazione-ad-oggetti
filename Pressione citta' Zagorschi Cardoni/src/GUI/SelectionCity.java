package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionCity extends JFrame implements ActionListener {

    private SelectionInformation window2;
    private JLabel citylabel;
    private JTextField nameCityText;
    private JButton search;

    public SelectionCity(String title) {

        /**
         *  crea il JFrame
         *
         */
        super(title);
        /**
         * Imposta la dimensione della finestra.
         */
        this.setSize(350, 200);
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
        citylabel = new JLabel("Name city");
        citylabel.setBounds(10,20,80,25);
        panel.add(citylabel);

        nameCityText = new JTextField(20);
        nameCityText.setBounds(100,20,80,25);
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

    //Impostare la verifica del nome inserito dall'utente.
    @Override
    public void actionPerformed(ActionEvent e) {
        String cityName = nameCityText.getText();
        this.setVisible(false);

        this.window2  = new SelectionInformation("Selection information", cityName);
        window2.setVisible(true);

    }
}
