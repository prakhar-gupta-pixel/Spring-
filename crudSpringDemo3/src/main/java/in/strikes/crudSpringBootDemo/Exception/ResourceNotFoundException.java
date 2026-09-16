package in.strikes.crudSpringBootDemo.Exception;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String message) {
        super(message);
    }
}
