package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionPeriod extends JFrame implements ActionListener {

    public SelectionPeriod(){

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

        JButton daily = new JButton("Daily");
        daily.setBounds(10,80,80,25);
        //daily.addActionListener();



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
