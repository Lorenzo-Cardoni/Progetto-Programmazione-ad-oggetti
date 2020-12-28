package Filters;

import Model.Pressure;
import Statistics.Stats;
import Utils.CalculateDay;
import Utils.FiltersUtil;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class FilterPressureStandard implements Filter {


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

    private LocalDate endPeriod;

    private Vector <Pressure> pressures = new Vector<>();

    private CalculateDay calculateDay = new CalculateDay();

    private FiltersUtil util;

    private Map<String, Vector<Pressure>> allPressures = new HashMap<>();


    public FilterPressureStandard(int days, String name, Map<String, Vector<Pressure>> allPressures){
        this.cityName = name;
        this.startPeriod = this.calculateDay.getDate(days);
        this.endPeriod = LocalDate.now();
        this.util = new FiltersUtil();
        this.allPressures = allPressures;
    }


    @Override
    public String filtersPressure() {

        this.pressures = this.allPressures.get(this.cityName);

        this.pressureFiltred = this.util.getPressureFiltred(this.pressures, this.startPeriod, this.endPeriod);


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
