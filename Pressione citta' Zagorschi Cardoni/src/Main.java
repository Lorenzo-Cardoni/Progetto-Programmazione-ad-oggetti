import Database.ReadFile;
import Utils.ConvertHashMapToVector;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        ConvertHashMapToVector convert = new ConvertHashMapToVector();
        convert.convertHashMapToVector(readFile.readFile("Pesaro"));
        /**
         * sistemare eccezione file inesistente per read file
         */
        //Api api=new Api();
        //api.callApi("Pesaro");
        System.out.print("Operazion finite");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
