import Database.ReadFile;
import Service.Api;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        Api api=new Api();
        api.callApi("Pesaro");
        readFile.readFile("Pesaro");
        /**
         * sistemare eccezione file inesistente per read file
         */
        System.out.print(" Operazioni finite ");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
