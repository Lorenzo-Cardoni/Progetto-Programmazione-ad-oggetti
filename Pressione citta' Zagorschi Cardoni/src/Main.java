import Database.ReadFile;
import Service.Api;
import Utils.ConvertHashMapToVector;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        Api api=new Api();
        ConvertHashMapToVector convert = new ConvertHashMapToVector();
        /**
         * sistemare eccezione file inesistente per read file
         */
        api.callApi("Pesaro");
        convert.convertHashMapToVector(readFile.readFile("Pesaro"));
        System.out.print(" Operazioni finite ");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
