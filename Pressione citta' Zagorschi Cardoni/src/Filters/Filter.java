package Filters;
import Model.Pressure;

import java.time.LocalDate;
import java.util.Map;
import java.util.Vector;

public abstract class Filter {

    private Vector<Pressure> pressureFiltred = new Vector<Pressure>();

    private String cityName;

    private LocalDate startPeriod;

    private LocalDate endPeriod;

    public Filter(String name){

        this.cityName = name;


    }

    public  abstract String filtersPressure(Map<String,Vector<Pressure>> pressures);

}
