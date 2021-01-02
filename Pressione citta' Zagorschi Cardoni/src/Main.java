import Database.ReadFile;
import GUI.SelectionCity;
import Service.ApiController;
import Utils.ConvertHashMapToVector;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        ConvertHashMapToVector convert = new ConvertHashMapToVector();
        convert.convertHashMapToVector(readFile.readFile("Pesaro"));
        /**
         * sistemare eccezione file inesistente per read file
         */
        ApiController api=new ApiController();
        api.callApi("Pesaro");
        System.out.print("Operazion finite");
        SelectionCity window1 = new SelectionCity("City Name");
    }
}
