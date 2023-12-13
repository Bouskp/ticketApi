package derek.exemple.ticketapi.Models;

import derek.exemple.ticketapi.Enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private int id;
    @NotNull @NotBlank
    private String nom;
    @NotNull @NotBlank
    private String prenom;
    @Email @NotNull @NotBlank @Column(unique = true)
    private String email;
    @Column(name = "usertype")
    private UserType type;
    @NotNull @NotBlank
    private String contact;
}
