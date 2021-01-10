package Statistics;
import Model.Pressure;
import java.util.Vector;

/**
 * classe mi crea le statiste delle pressioni contenute in un vettore.
 */
public class Stats {


    /**
     * Vettore contenete le pressioni per generare le statistiche.
     */
    private Vector<Pressure> pressure;

    /**
     * Valore minimo
     */
    private float val_min;

    /**
     * valore massimo
     */
    private float val_max;

    /**
     * Media
     */
    private float average = 0;

    /**
     * Varianza
     */
    private float variance = 0;

    /**
     * contatore.
     */
    private int count =0;

    /**
     * Costruttore della classe Stats
     * @param pressure
     */
    public Stats(Vector <Pressure> pressure){

        this.pressure = pressure;

    }

    /**
     * Metodo che crea le statistiche.
     */
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

        this.average /= this.count;

    }

    /**
     * Getter della media.
     * @return media
     */
    public float getAverage(){
        return this.average;
    }

    /**
     * Getter della Varianza
     * @return Varianza
     */
    public float getVariance(){

        this.average = this.getAverage();
        this.count = 0;
        for(Pressure p : pressure){
            this.variance += Math.pow(p.getValue()-this.average,2);
            this.count++;
        }

        return this.variance /= this.count;
    }

    /**
     * Getter del valore minimo
     * @return Valore minimo
     */
    public float getVal_min(){ return this.val_min;}

    /**
     * getter del valore massimo
     * @return Valore massimo
     */
    public float getVal_max(){ return this.val_max;}

}
