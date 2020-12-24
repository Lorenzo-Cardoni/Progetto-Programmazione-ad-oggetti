package Model;

import java.time.LocalDateTime;

public class Pressure {
    public float value;
    public String time;
    public String nameCity;
    public LocalDateTime date;

    public Pressure(){}
    public Pressure(float valuePressure, String time, LocalDateTime date, String nameCity){
        this.value = valuePressure;
        this.time = time;
        this.date = date;
        this.nameCity = nameCity;
    }

    public float getValue(){ return this.value;}

    public String getTime(){ return this.time; }

    public String getDate(){ return this.date.toString(); }

    public String getNameCity(){
        return this.nameCity;
    }
}
