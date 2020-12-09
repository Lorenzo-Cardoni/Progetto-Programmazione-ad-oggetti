package Pressure;

public class Pressure {
    private float value;
    private float time;
    private String nameCity;

    public Pressure(float valuePressure, float time, String nameCity){
        this.value = valuePressure;
        this.time = time;
        this.nameCity = nameCity;
    }

    public float getValue(){
        return this.value;
    }

    public float getTime(){
        return this.time;
    }

    public String getNameCity(){
        return this.nameCity;
    }
}
