import Service.Api;

public class Main {
    public static void main(String[] args) {
        Api api=new Api();
        api.callApi("Pesaro");
        System.out.print("Operazione finita");
        //SelectionCity window1 = new SelectionCity("City Name");
    }
}
