package Filters;
import Model.Pressure;

import java.util.Vector;

public interface Filter {


    /**
     *
     * @param pressures sara' il vettore contenente le informazione sulla pressione
     * @param date
     * @return
     */
    public String filtersPressure(Vector<Pressure> pressures, String date, String name);


}
