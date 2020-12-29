import Database.ReadFile;
import Service.Api;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.readFile();
        Api api=new Api();
        api.callApi("Pesaro");
        System.out.print("Operazione finita");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
