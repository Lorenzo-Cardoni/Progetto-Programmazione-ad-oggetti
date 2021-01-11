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
     *  Data di inizio periodo.
     */
    private LocalDate startPeriod;

    /**
     * Data di fine periodo.
     */
    private LocalDate endPeriod;

    /**
     * Vettore contenente le pressioni di una determinata citta'.
     */
    private Vector <Pressure> pressures = new Vector<>();


    private CalculateDay calculateDay = new CalculateDay();

    private FiltersUtil util;

    /**
     * Costruttore della classe FilterPressureStandard
     *
     * @param days giorni della durata del periodo personalizzato.
     * @param allPressures Vettore di pressioni di una determinata citta'.
     *
     */
    public FilterPressureStandard(int days, Vector<Pressure> allPressures){

        this.startPeriod = this.calculateDay.getDate(days);
        this.endPeriod = LocalDate.now();
        this.util = new FiltersUtil();
        this.pressures = allPressures;
    }

    /**
     * Metodo che mi ritorna in output il vettore di pressioni filtrato
     * @return
     */
    @Override
    public Vector<Pressure> filtersPressure() {

        this.pressureFiltred = this.util.getPressureFiltred(this.pressures, this.startPeriod, this.endPeriod);

        return this.pressureFiltred;

    }
}
