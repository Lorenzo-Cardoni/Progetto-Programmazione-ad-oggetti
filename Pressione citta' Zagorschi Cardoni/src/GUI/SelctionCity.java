package GUI;

import javax.swing.*;

public class SelctionCity {

    public SelctionCity() {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        /**
         * Imposta la dimensione della finestra.
         */
        frame.setSize(400, 400);
        /**
         *  Specifica che la chiusura della finestra deve far terminare il programma.
         */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * Specifica che la finestra deve essere centrata.
         */
        frame.setLocationRelativeTo(null);

        /**
         * Visualizza la finestra.
         */
        frame.setVisible(true);
        frame.add(panel);

        /**
         * Inizializzo la casella di input dove verra' inserito il nome
         * della citta'.
         */
        JLabel label = new JLabel("Name city");
        label.setBounds(10,20,80,25);
        panel.add(label);

        JTextField nameCityText = new JTextField(20);
        nameCityText.setBounds(100,20,165,25);
        panel.add(nameCityText);

    }

}
