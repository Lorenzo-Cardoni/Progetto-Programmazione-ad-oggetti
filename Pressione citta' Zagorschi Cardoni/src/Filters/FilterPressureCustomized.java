package Filters;

import Model.Pressure;
import Statistics.Stats;
import Utils.FiltersUtil;
import Exception.*;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Vector;

/**
 *  Questa classe filtra le pressioni in base al nome della citta' e alla data di inizio del periodo e della fine.
 *
 */
public class FilterPressureCustomized implements Filter{

    /**
     *  Vettore con le pressioni filtrate.
     *
     */
    private Vector<Pressure> pressureFiltred = new Vector<Pressure>();

    /**
     *  Data di inizio periodo.
     */
    private LocalDate startPeriod;

    /**
     *  Data di fine periodo.
     */
    private LocalDate endPeriod;

    private FiltersUtil utils;

    private Vector <Pressure> pressures = new Vector<>();


    public FilterPressureCustomized(String date1, String date2, Vector<Pressure> allPressures) throws PressureException {

        if(date1.equals("")){
            JOptionPane.showMessageDialog(null,"Inserire la data iniziale");
            throw new PressureException("MESSAGE: Inserire la data iniziale");
        }


        try
        {
            this.startPeriod = LocalDate.parse(date1);
        }
        catch (DateTimeException e)
        {
            JOptionPane.showMessageDialog(null,"Inserire data iniziale nel formato 'aaaa-mm-dd'");
            System.out.println("MESSAGE: Formato data iniziale errato");
        }

        if(date2.equals("")){
            JOptionPane.showMessageDialog(null,"Inserire la data finale");
            throw new PressureException("MESSAGE: Inserire la data finale");
        }

        try
        {
           this.endPeriod = LocalDate.parse(date2);
        }
        catch (DateTimeException e)
        {
            JOptionPane.showMessageDialog(null,"Inserire data finale nel formato 'aaaa-mm-dd'");
            System.out.println("MESSAGE: Formato data finale errato");
        }

        this.utils = new FiltersUtil();
        this.pressures = allPressures;
    }


    public String filtersPressure() {

        this.pressureFiltred = this.utils.getPressureFiltred(this.pressures,this.startPeriod,this.endPeriod);

        /**
         * crea un riferimento alla classe dove risiedono i metodi delle statistiche.
         *
         */
        Stats statistics = new Stats(this.pressureFiltred);

        /**
         * crea le varie statistiche.
         *
         */
        statistics.createStats();

        /**
         * Output di tipo stringa composto dai metodi della classe Stats.
         *
         */
        return "Minimum value is "+statistics.getVal_min()+"\nMaximum value is "+statistics.getVal_max()+
                "\nAvarege is "+statistics.getAverage()+"\nVariance is "+statistics.getVariance();
    }
}
