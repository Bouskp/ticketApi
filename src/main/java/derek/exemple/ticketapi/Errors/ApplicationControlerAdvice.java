package derek.exemple.ticketapi.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class ApplicationControlerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundError.class})
    public @ResponseBody ErrorData handleException(EntityNotFoundError error) {
        return ErrorData.builder().statusCode(HttpStatus.NOT_FOUND.value()).message(error.getMessage()).timestamp(new Date()).build();
    }
}
