package derek.exemple.ticketapi.Errors;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class EntityNotFoundError extends RuntimeException {

    public EntityNotFoundError(String message) {
        super(message);
    }
}
