package derek.exemple.ticketapi.Errors;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorData {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}
