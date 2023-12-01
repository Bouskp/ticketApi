package derek.exemple.ticketapi.Models;

import derek.exemple.ticketapi.Enums.TicketType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private Long id;
    private int numSiege;
    private TicketType type;
    private int prix;
}
