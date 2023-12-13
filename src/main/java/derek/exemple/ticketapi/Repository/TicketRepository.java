package derek.exemple.ticketapi.Repository;

import derek.exemple.ticketapi.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
