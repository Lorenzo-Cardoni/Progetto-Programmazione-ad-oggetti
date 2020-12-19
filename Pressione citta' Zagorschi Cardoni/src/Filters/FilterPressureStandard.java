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

    /**
     *  Questa classe filtra le pressioni in base al nome della citta' e alla data.
     *
     * @param pressures vettore in input che contiene tutti i valori delle pressioni.
     * @return In output ottengo una stringa con i valori delle statistiche
     */
    @Override
    public String filtersPressure(Vector<Pressure> pressures) {

        /**
         * Ciclo for che mi sfoglia tutto il vettore contenente le pressioni non filtrate.
         */
        for(int i=0; i < pressures.size(); i++){

            /**
             * localDate attributo che mi prende la data da cui inizia il periodo.
             */

            //messa come commento, da errore, mi serve eseguire il main
            //LocalDate localDate = LocalDate.parse(pressures.get(i).getDate());

            /**
             *  Ciclo if che mi permette di filtrare le pressioni in base al nome e alla data.
             *  Si e' utilizzato un metodo della libreria time di java.
             */

            //messa come commento, da errore, mi serve eseguire il main
            //if(pressures.get(i).getNameCity() == cityName && localDate.isAfter(startPeriod))
                //this.pressureFiltred.add(pressures.get(i));

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
