package derek.exemple.ticketapi.Models;

import derek.exemple.ticketapi.Enums.TicketType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Min(1)
    private int numSiege;
    @Column(name = "ticket_type")
    private TicketType type;
    @NotNull
    private int prix;
}
