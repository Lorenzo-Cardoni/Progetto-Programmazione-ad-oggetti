package Filters;

import Model.Pressure;
import Statistics.Stats;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Vector;

//utilizzare la classe abstract.
/**
 *  Questa classe filtra le pressioni da adesso ad una data scelta dall'utente.
 *
 *
 */
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

    /**
     *  Data di fine periodo.
     */
    private LocalDate endPeriod;



    public FilterPressureStandard(String date, String name){
        this.cityName = name;
        this.endPeriod = LocalDate.now();
        this.startPeriod = LocalDate.parse(date);
    }


    @Override
    public String filtersPressure(Vector<Pressure> pressures) {

        for(int i=0; i < pressures.size(); i++){

            LocalDate localDate = LocalDate.parse(pressures.get(i).getDate());

            if(pressures.get(i).getNameCity() == cityName && localDate.isAfter(startPeriod))
                this.pressureFiltred.add(pressures.get(i));

        }

        Stats statistics = new Stats(this.pressureFiltred);

        statistics.createStats();


        return "Minimum value is "+statistics.getVal_min()+"\nMaximum value is "+statistics.getVal_max()+
                "\nAvarege is "+statistics.getAverage()+"\nVariance is "+statistics.getVariance();
    }
}
