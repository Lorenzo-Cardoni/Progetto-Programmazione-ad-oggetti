package Statistics;

import Model.Pressure;

public class Stats {
    private String nameCity;
    private String duration;
    private Pressure[] pressure;
    private float val_min;
    private float val_max;
    private float average;
    private float variance;

    public Stats(){};

    public Stats(String nameCity , String duration , Pressure[] pressure){
        this.duration = duration;
        this.nameCity = nameCity;
        this.pressure = pressure;
    }

    public void createStatistics(){
        for(int i=0 ; i < this.pressure.length ; i++){
            if(pressure.value[i] > val_max)
                val_max=pressure.value[i];
            if(pressure.value[i]<val_min)
                val_min=pressure.value[i];
            average+=pressure.value[i];
        }
        average /= pressure.length;

        for(int i=0;i<this.pressure.length;i++){
            variance+=((pressure.value[i]-average)*(pressure.value[i]-average))/average;
        }
    }
}