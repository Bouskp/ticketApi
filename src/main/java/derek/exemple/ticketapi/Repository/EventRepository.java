package derek.exemple.ticketapi.Repository;

import derek.exemple.ticketapi.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
