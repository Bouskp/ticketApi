package derek.exemple.ticketapi.Models;

import derek.exemple.ticketapi.Enums.TypeEvent;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;

@Data
@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date date;
    private TimeZone heure;
    private String adresse;
    private TypeEvent event;

}
