package in.strikes.crudSpringBootDemo.Exception;


import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity <String> DuplicateResourceException(DuplicateResourceException e ) {

        return  ResponseEntity.
                status(HttpStatus.CONFLICT).
                body(e.getMessage());
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity <String> handleResourceNotFoundException(ResourceNotFoundException e ) {

        return  ResponseEntity.
                status(HttpStatus.NOT_FOUND).
                body(e.getMessage());
    }

     @ExceptionHandler(RuntimeException.class)
    public ResponseEntity <String> handleRuntimeException( RuntimeException e ) {

         return  ResponseEntity.
                 status(HttpStatus.INTERNAL_SERVER_ERROR).
                 body(e.getMessage());
     }




    @ExceptionHandler(Exception.class)
    public ResponseEntity <String> handleGenericException( Exception e ) {

        return  ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(e.getMessage());
    }

}
