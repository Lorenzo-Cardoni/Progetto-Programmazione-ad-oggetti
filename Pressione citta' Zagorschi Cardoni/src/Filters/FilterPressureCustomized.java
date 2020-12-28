package Filters;

import Model.Pressure;
import Statistics.Stats;
import Utils.FiltersUtil;

import java.time.LocalDate;
import java.util.Map;
import java.util.Vector;

/**
 *  Questa classe filtra le pressioni in base al nome della citta' e alla data di inizio del periodo e della fine.
 *
 */
public class FilterPressureCustomized extends Filter{

    /**
     *  Vettore con le pressioni filtrate.
     *
     */
    private Vector<Pressure> pressureFiltred = new Vector<Pressure>();


    /**
     *  Nome della citta' da filtrare.
     *
     */
    private String cityName;

    /**
     *  Data di inizio periodo.
     */
    private LocalDate startPeriod;

    /**
     *  Data di fine periodo.
     */
    private LocalDate endPeriod;

    private FiltersUtil utils;


    public FilterPressureCustomized(String date1, String date2, String name){
        super(name);
        this.startPeriod = LocalDate.parse(date1);
        this.endPeriod = LocalDate.parse(date2);
        this.utils = new FiltersUtil();
    }

    @Override
    public String filtersPressure(Map<String, Vector<Pressure>> pressures) {


        this.pressureFiltred = this.utils.getPressureFiltred(pressures,this.startPeriod,this.endPeriod,this.cityName);

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
