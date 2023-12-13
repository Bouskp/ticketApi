package derek.exemple.ticketapi.DTO;

import derek.exemple.ticketapi.Enums.UserType;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private UserType type;
    private String contact;
}
