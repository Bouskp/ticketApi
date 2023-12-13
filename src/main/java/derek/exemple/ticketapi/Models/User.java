package derek.exemple.ticketapi.Models;

import derek.exemple.ticketapi.Enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @Email @NotNull
    private String email;
    @Column(name = "usertype")
    private UserType type;
    @NotNull
    private String contact;
}
