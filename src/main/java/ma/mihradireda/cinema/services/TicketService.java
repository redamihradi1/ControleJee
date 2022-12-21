package ma.mihradireda.cinema.services;

import lombok.AllArgsConstructor;
import ma.mihradireda.cinema.dto.TicketDto;
import ma.mihradireda.cinema.entities.Match;
import ma.mihradireda.cinema.entities.Ticket;
import ma.mihradireda.cinema.enums.Statut;
import ma.mihradireda.cinema.repos.MatchRepo;
import ma.mihradireda.cinema.repos.TicketRepo;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@AllArgsConstructor
@Service
public class TicketService implements ITicket{
    MatchRepo matchRepo;
    TicketRepo ticketRepo;
    @Override
    public Ticket ajouterTicket(Long idMatch, TicketDto ticketDto) {
        Match match = matchRepo.findById(idMatch).orElse(null);
        if(match!=null){
            if(match.getNombreTicket() > 0){
                Ticket ticket = new Ticket();
                ticket.setReferenceTicket(ticketDto.getReferenceTicket());
                ticket.setPrix(ticketDto.getPrix());
                ticket.setStatut(Statut.ACTIF);
                ticket.setMatch(match);
                ticketRepo.save(ticket);
                match.setNombreTicket(match.getNombreTicket()-1);

                matchRepo.save(match);

                return ticket;
            }
            return null;
        }
        return null;
    }

    @Override
    public boolean modifierStatutTicket(Long idticket) {
        Ticket ticket =ticketRepo.findById(idticket).orElse(null);
        if(ticket != null){
            ticket.setStatut(Statut.NO_ACTIF);
            ticketRepo.save(ticket);
            return true;
        }
        return false;
    }

    @Override
    public boolean supprimerTicket(Long idTicket) {
        Ticket ticket = ticketRepo.findById(idTicket).orElse(null);

        if (ticket!= null){

            Match match = matchRepo.findById(ticket.getMatch().getId()).orElse(null);
            match.setNombreTicket(match.getNombreTicket()+1);
            matchRepo.save(match);
            ticketRepo.delete(ticket);

            return true;
        }

        return false;
    }


}
