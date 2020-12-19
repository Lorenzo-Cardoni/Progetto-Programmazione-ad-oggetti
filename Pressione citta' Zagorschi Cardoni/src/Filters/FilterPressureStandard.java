package Filters;

import Model.Pressure;
import Statistics.Stats;
import java.time.LocalDate;
import java.util.Vector;

//utilizzare la classe abstract.
/**
 *  Questa classe filtra le pressioni da adesso ad una data scelta dall'utente.
 *
 *
 */
public class FilterPressureStandard extends Filter {

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

    CalculateDay date = new CalculateDay();


    public FilterPressureStandard(int day, String name){
        super(name);
        this.startPeriod = date.getDate(day);
        this.endPeriod = LocalDate.now();
    }

    /**
     *  Questa classe filtra le pressioni in base al nome della citta' e alla data di inizio del periodo.
     *
     * @param pressures vettore in input che contiene tutti i valori delle pressioni.
     * @return In output ottengo una stringa con i valori delle statistiche
     */
    @Override
    public String filtersPressure(Vector<Pressure> pressures) {

        /**
         * supportDate attributo che mi prende la data da cui inizia il periodo.
         *
         */

        LocalDate supportDate;
        /**
         * Ciclo for che mi sfoglia tutto il vettore contenente le pressioni non filtrate.
         *
         */
        for(int i=0; i < pressures.size(); i++){

            supportDate = LocalDate.parse(pressures.get(i).getDate());

            /**
             *  Ciclo if che mi permette di filtrare le pressioni in base al nome e alla data.
             *  Si e' utilizzato un metodo della libreria time di java.
             */

            if(pressures.get(i).getNameCity().equals(cityName) && supportDate.isAfter(this.startPeriod))
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

        return "Minimum value is "+statistics.getVal_min()+"\nMaximum value is "+statistics.getVal_max()+
                "\nAvarege is "+statistics.getAverage()+"\nVariance is "+statistics.getVariance();
    }
}
