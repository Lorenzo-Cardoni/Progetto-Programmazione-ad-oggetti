package Pressure;

public class Statistics {
    private String nameCity;
    private String duration;
    private Pressure[] pressure;
    private float val_min;
    private float val_max;
    private float average;
    private float variance;

    public Statistics(){};

    public Statistics(String nameCity,String duration, Pressure[] pressure){
        this.duration=duration;
        this.nameCity=nameCity;
        this.pressure=pressure;
    };
    void createStatistics(){
        for(int i=0;i<this.pressure.length;i++){
            if(pressure.value>val_max)val_max=pressure.value;
            if(pressure.value<val_min)val_min=pressure.value;
            average+=pressure.value;
        }
        average/=pressure.length;
    }
}
