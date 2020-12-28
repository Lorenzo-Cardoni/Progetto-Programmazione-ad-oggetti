package Utils;

import Model.Pressure;

import java.time.LocalDate;
import java.util.Vector;

public class FiltersUtil {

    /**
     * Vettore con le pressioni filtrate.
     */
    private Vector<Pressure> pressureFiltred = new Vector<Pressure>();


    public Vector<Pressure> getPressureFiltred(Vector<Pressure> allPressures, LocalDate startPeriod, LocalDate endPeriod)
    {

        LocalDate supportDate;

        this.pressureFiltred.clear();

        /**
         * for each che mi sfoglia tutto il vettore contenente le pressioni non filtrate.
         *
         */
            try {

                for (Object o : allPressures) {
                    if (o == null) {
                        System.out.println("Pressure not found");
                        return this.pressureFiltred;
                    }

                    if (o instanceof Pressure) {
                        Pressure pressure = (Pressure) o;


                        /**
                         * localDate attributo che mi prende la data da cui inizia il periodo.
                         *
                         */
                        supportDate = LocalDate.parse(pressure.getDate());

                        /**
                         *  Ciclo if che mi permette di filtrare le pressioni in base al nome e alla data.
                         *  Si e' utilizzato un metodo della libreria time di java.
                         */
                        if (supportDate.isAfter(startPeriod.minusDays(1)) && supportDate.isBefore(endPeriod.plusDays(1)))
                            this.pressureFiltred.add(pressure);
                    }
                }
            } catch (Exception e) {
                System.out.println("ERRORE.");
                System.out.println("MESSAGGIO: " + e.getMessage());
                System.out.println("CAUSA: " + e.getCause());
            }

        return this.pressureFiltred;
    }
}
