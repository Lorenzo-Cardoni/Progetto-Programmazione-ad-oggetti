package Model;

/**
 *Classe che modella la città della pressione.
 * @author Cardoni Lorenzo
 * @author Zagorschi Franco
 */
public class City {

    /**
     * nome della città.
     */
    private String cityname;

    /**
     * nome della regione.
     */
    private String region;

    /**
     *ID della città
     */
    private int ID_city;

    /**
     * Costruttore della classe City che inizializza una istanza.
     * @param cityname nome della citta'.
     * @param nameregion nome della regione.
     * @param ID_city ID della citta.
     */
    public City(String cityname, String nameregion, int ID_city){
        this.cityname = cityname;
        this.region = nameregion;
        this.ID_city = ID_city;
    }

    /**
     *Getter del nome della citta'.
     * @return cityname Ritorna il nome della citta'.
     */
    public String getCityname(){ return this.cityname; }

    /**
     *
     * @return
     */
    public String getRegion(){ return this.region; }

    /**
     *
     * @return
     */
    public int getPostalCode(){return this.ID_city;}
}
