package Pressure;

public class Statistics {
    private String nameCity;
    private String duration;
    private float val_min;
    private float val_max;
    private float average;
    private float variance;

    public Statistics(){};

    public Statistics(String nameCity,String duration){
        this.duration=duration;
        this.nameCity=nameCity;
    };

}
