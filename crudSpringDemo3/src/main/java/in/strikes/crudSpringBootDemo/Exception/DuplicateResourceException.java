package in.strikes.crudSpringBootDemo.Exception;

public class DuplicateResourceException  extends RuntimeException{


    public DuplicateResourceException(String message){
        super(message);
    }
}
