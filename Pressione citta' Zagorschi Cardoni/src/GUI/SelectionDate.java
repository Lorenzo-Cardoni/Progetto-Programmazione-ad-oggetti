package GUI;

import Database.ReadFile;
import Filters.FilterPressureCustomized;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionDate extends JFrame implements ActionListener {
    private String cityName;
    private JPanel panel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JTextField startDateText;
    private JTextField endDateText;
    private JButton calculate;
    private ShowStatsCustomized window4;

    private FilterPressureCustomized filter;
    private ReadFile vectorOfPressure = new ReadFile();

    public SelectionDate(String title, String name){

        super(title);
        /**
         * Imposta la dimensione della finestra.
         */
        setSize(600, 400);

        /**
         *  Specifica che la chiusura della finestra deve far terminare il programma.
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String date1 = startDateText.getText();
        String date2 = endDateText.getText();

        filter = new FilterPressureCustomized(date1, date2, vectorOfPressure.readFile(this.cityName));

        JOptionPane.showMessageDialog(null,"Le statistiche della pressione nella citta' "+this.cityName+" sono:\n"
                +this.filter.filtersPressure());

    }
}
