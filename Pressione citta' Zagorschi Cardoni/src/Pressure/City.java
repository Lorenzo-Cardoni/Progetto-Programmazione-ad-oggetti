package Pressure;

public class City {
    private String cityname;
    private String region;
    private int postalCode;

    public City(String cityname, String nameregion, int postalCode){
        this.cityname = cityname;
        this.region = nameregion;
        this.postalCode = postalCode;
    }

    public String getCityname(){
        return this.cityname;
    }

    public String getRegion(){
        return this.region;
    }

    public int getPostalCode(){
        return this.postalCode;
    }
}
