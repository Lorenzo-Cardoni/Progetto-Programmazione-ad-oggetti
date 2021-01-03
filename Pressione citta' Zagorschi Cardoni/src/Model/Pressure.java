package Model;

/**
 * Modello della pressione.
 */
public class Pressure {
    /**
     * Valore della pressione.
     */
    public float value;

    /**
     * Tempo della misurazione.
     */
    public String time;

    /**
     * Nome citta' relativa alla pressione misurata.
     */
    public String nameCity;

    /**
     * Data della misurazione.
     */
    public String date;

    /**
     * Costruttore della classe Pressure
     * @param valuePressure
     * @param time
     * @param date
     * @param nameCity
     */
    public Pressure(float valuePressure, String time, String date, String nameCity){
        this.value = valuePressure;
        this.time = time;
        this.date = date;
        this.nameCity = nameCity;
    }

    /**
     * getter del valore della pressione
     * @return
     */
    public float getValue(){ return this.value;}

    /**
     * getter del tempo
     * @return
     */
    public String getTime(){ return this.time; }

    /**
     * getter della data
     * @return
     */
    public String getDate(){ return this.date.toString(); }

    /**
     * getter del nome della citta'.
     * @return
     */
    public String getNameCity(){
        return this.nameCity;
    }
}
