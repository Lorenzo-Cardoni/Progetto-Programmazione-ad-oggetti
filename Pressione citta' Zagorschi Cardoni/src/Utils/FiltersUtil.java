package Utils;

import Model.Pressure;

import java.time.LocalDate;
import java.util.Map;
import java.util.Vector;

public class FiltersUtil {

    /**
     * Vettore con le pressioni filtrate.
     */
    private Vector<Pressure> pressureFiltred = new Vector<Pressure>();


    public Vector<Pressure> getPressureFiltred(Map<String, Vector<Pressure>> allPressures, LocalDate startPeriod, LocalDate endPeriod, String cityName) {

        LocalDate supportDate;

        this.pressureFiltred.clear();

        /**
         * for each che mi sfoglia tutto il vettore contenente le pressioni non filtrate.
         *
         */
        if(allPressures.containsKey(cityName)) {
            try {

                for (Object o : allPressures.get(cityName)) {
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
                        if (supportDate.isAfter(startPeriod) && supportDate.isBefore(endPeriod))
                            this.pressureFiltred.add(pressure);
                    }
                }
            } catch (Exception e) {
                System.out.println("ERRORE.");
                System.out.println("MESSAGGIO: " + e.getMessage());
                System.out.println("CAUSA: " + e.getCause());
            }
        }
        return this.pressureFiltred;
    }
}
