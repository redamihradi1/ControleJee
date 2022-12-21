package ma.mihradireda.cinema.repos;


import ma.mihradireda.cinema.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepo extends JpaRepository<Match,Long> {
    List<Match> findByNombreTicketEquals(int nbr);
}
