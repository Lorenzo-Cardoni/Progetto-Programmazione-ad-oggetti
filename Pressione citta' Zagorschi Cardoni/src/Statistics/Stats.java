package Statistics;
import Model.Pressure;
import java.util.Vector;

public class Stats {
    private String nameCity;
    private String duration;
    private Vector<Pressure> pressure;
    private float val_min = 0;
    private float val_max = 0;
    private float average = 0;
    private float variance = 0;
    private int count =0;

    //Il vettore pressure sara' generato da un'altra classe.

    public Stats(String nameCity , String duration , Vector <Pressure> pressure){
        this.duration = duration;
        this.nameCity = nameCity;
        this.pressure = pressure;
    }

    public void createStats() {
        for (int i = 0; i < pressure.size(); i++) {

            if (pressure.get(i).getValue() > this.val_max)
                this.val_max = pressure.get(i).getValue();

            if (pressure.get(i).getValue() < this.val_min)
                this.val_min = pressure.get(i).getValue();

            this.average += pressure.get(i).getValue();

            this.count++;
        }
    }

    public float getAverage(){
        return this.average /= this.count;
    }

    public float getVariance(){

        for(int i = 0; i < pressure.size(); i++){
            this.variance += (pressure.get(i).getValue()-this.average)*(pressure.get(i).getValue()-this.average);
        }

        return this.variance /= this.count;
    }

    public float getVal_min(){ return this.val_min;}

    public float getVal_max(){ return this.val_max;}

}
