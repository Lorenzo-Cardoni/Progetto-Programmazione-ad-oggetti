package Statistics;
import Model.Pressure;
import java.util.Vector;

public class Stats {

    private Vector<Pressure> pressure;
    private float val_min;
    private float val_max;
    private float average = 0;
    private float variance = 0;
    private int count =0;

    //Il vettore pressure sara' generato da un'altra classe.

    public Stats(Vector <Pressure> pressure){

        this.pressure = pressure;

    }

    public void createStats() {
        for (int i = 0; i < pressure.size(); i++) {

            if(i == 0) {
                this.val_min = pressure.get(i).getValue();
                this.val_max = pressure.get(i).getValue();
            }

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

        this.average = this.getAverage();

        for(Pressure p : pressure){
            this.variance += (p.getValue()-this.average)*(p.getValue()-this.average);
        }

        return this.variance /= this.count;
    }

    public float getVal_min(){ return this.val_min;}

    public float getVal_max(){ return this.val_max;}

}
