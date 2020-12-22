package Model;

public class Pressure {
    public float value;
    public String time;
    public String date;
    public String nameCity;

    public Pressure(){}
    public Pressure(float valuePressure, String time, String date, String nameCity){
        this.value = valuePressure;
        this.time = time;
        this.date = date;
        this.nameCity = nameCity;
    }

    public float getValue(){ return this.value;}

    public String getTime(){ return this.time; }

    public String getDate(){ return this.date; }

    public String getNameCity(){
        return this.nameCity;
    }
}
