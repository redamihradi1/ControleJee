package ma.mihradireda.cinema.dto;

import lombok.Data;
import ma.mihradireda.cinema.entities.Match;
import ma.mihradireda.cinema.enums.Statut;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
public class TicketDto {

    private String referenceTicket;
    private double prix;

}
