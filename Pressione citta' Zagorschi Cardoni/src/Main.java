import Database.ReadFile;
import Service.ApiController;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        ApiController api=new ApiController();
            api.callApi("asfasfasfas");
        readFile.readFile("Fano");
        /**
         * sistemare eccezione file inesistente per read file
         */
        System.out.print(" Operazioni finite ");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
