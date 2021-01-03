package Exception;

public class PressureException extends Exception{

    private String msg;

    public PressureException(String message){
        super();
        this.msg = message;
        System.out.println(this.msg);
    }

}
