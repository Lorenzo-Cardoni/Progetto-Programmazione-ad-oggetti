import Database.ReadFile;
import Service.ApiController;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        ApiController api=new ApiController();
        api.callApi("Pesaro");
        api.callApi("Padova");

        readFile.readFile("Fano");
        /**
         * sistemare eccezioni
         * sistemare codice
         * chiave in file
         */
        System.out.print(" Operazioni finite ");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
