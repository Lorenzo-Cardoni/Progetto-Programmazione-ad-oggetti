package Filters;

import Model.Pressure;
import Statistics.Stats;

import java.time.LocalDate;
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

    public FilterPressureCustomized(String date1, String date2, String name){
        super(name);
        this.startPeriod = LocalDate.parse(date1);
        this.endPeriod = LocalDate.parse(date2);
    }

    @Override
    public String filtersPressure(Vector<Pressure> pressures) {

        /**
         * Ciclo for che mi sfoglia tutto il vettore contenente le pressioni non filtrate.
         *
         */
        for(int i=0; i < pressures.size(); i++){

            /**
             * localDate attributo che mi prende la data da cui inizia il periodo.
             *
             */
            LocalDate localDate = LocalDate.parse(pressures.get(i).getDate());

            /**
             *  Ciclo if che mi permette di filtrare le pressioni in base al nome e alla data.
             *  Si e' utilizzato un metodo della libreria time di java.
             */
            if(pressures.get(i).getNameCity() == cityName && localDate.isAfter(startPeriod) && localDate.isBefore(endPeriod))
                this.pressureFiltred.add(pressures.get(i));

        }

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
