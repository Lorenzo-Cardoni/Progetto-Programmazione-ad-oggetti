package Filters;

import Model.Pressure;

import java.util.Vector;

public interface Filter {

    /**
     * Interfaccia per le classi di filtraggio
     * @return
     *
     */
    public Vector<Pressure> filtersPressure();

}
