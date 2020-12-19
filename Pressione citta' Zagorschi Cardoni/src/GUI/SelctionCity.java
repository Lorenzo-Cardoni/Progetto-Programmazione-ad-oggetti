package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelctionCity extends JFrame implements ActionListener {

    public SelctionCity() {


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




        /**
         * Inizializzo la casella di input dove verra' inserito il nome
         * della citta'.
         */
        JLabel citylabel = new JLabel("Name city");
        citylabel.setBounds(10,20,80,25);
        add(citylabel);

        JTextField nameCityText = new JTextField(20);
        nameCityText.setBounds(100,20,165,25);
        add(nameCityText);

        JButton search = new JButton("Search");
        search.setBounds(10,80,80,25);
        search.addActionListener(new SelctionCity());
        add(search);



        /**
         * Visualizza la finestra.
         */
        setVisible(true);



    }

    //Impostare la verifica del nome inserito dall'utente.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
