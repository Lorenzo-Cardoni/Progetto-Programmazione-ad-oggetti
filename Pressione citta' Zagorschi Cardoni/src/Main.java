import GUI.SelectionCity;
import Service.ApiController;

/**
 * Classe Main del programma che gestisce l'avvio del programma
 */
public class Main {
    /**
     * Metodo main che fa partire l'applicazione
     * @param args nome della finestra principale
     */
    public static void main(String[] args) {
        /**
         * Avvio dell'Oggetto api che effettua chiamate in automatico con 3 citta' predefinite
         */
        ApiController api = new ApiController();
        api.startApi();
        /**
         * Finestra principale della GUI-
         */
        new SelectionCity("City Name");
    }
}
