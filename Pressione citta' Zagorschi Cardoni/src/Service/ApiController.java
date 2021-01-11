package Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

public class ApiController {
    /**
     * ApiController() Costruttore vuoto
     */
    public ApiController() {}
    private String cityName;
    private HttpURLConnection con;
    private String apiData;
    private JsonParse jsonParser;
    private Boolean cityExist;
    private Properties prop;
    private static String apiKey;
    private InputStream is = null;
    private String[] cityVector = {"pesaro", "fano", "agugliano", };
    private Timer timer = new Timer("Timer");
    private long delay = 1000L;
    private TimerTask task = new TimerTask() {
        public void run() {
            callApi(cityVector[0]);
            callApi(cityVector[1]);
            callApi(cityVector[2]);
        }
    };
    public void startApi(){
        timer.scheduleAtFixedRate(task, delay, 1 * 3600 * 1000);
    }
    /**
     *
     * @param city Stringa contentente nome della citta' di cui si vuole conoscere la pressione attuale
     * @return
     */
    public String callApi(String city) {
        prop = new Properties();
        try {
            is = new FileInputStream("src/config.editorconfig");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(is);
            apiKey="&appid=" + prop.getProperty("apiKey");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cityName="";
        apiData="";
        jsonParser = new JsonParse();
        cityExist=false;
        this.cityName = "q=" + city;
         try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?"+cityName+apiKey);
            con = (HttpURLConnection) url.openConnection();
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                cityExist=true;
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    apiData+=inputLine;
                in.close();
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        /**
         * @param jsonParser Se la citta' esiste, l'oggetto jsonParser estrae i dati dalla stringa apiData
         */
        if(cityExist){
             jsonParser.parseJsonString(apiData);
         }
        /**
         * Nel caso in cui il nome della citta' richiesta non esistesse nel database di myweather viene ritornata una stringa "ERRORE"
         * In caso contrario, il metodo ritorna il valore della pressione
         */
        if(cityExist){
             return jsonParser.getPressure();
         }else {
             System.out.println("ERROR");
             return "ERROR";
         }
    }
}