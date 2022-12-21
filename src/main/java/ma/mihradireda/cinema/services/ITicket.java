package ma.mihradireda.cinema.services;


import ma.mihradireda.cinema.dto.TicketDto;
import ma.mihradireda.cinema.entities.Ticket;

public interface ITicket {
    public Ticket ajouterTicket(Long idMatch,  TicketDto ticketDto);
    public boolean modifierStatutTicket(Long idticket);
    public boolean supprimerTicket(Long idTicket);

}
