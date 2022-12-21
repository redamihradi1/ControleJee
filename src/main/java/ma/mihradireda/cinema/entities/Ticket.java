package ma.mihradireda.cinema.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mihradireda.cinema.enums.Statut;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(length = 16,nullable = false,unique = true)
    private String referenceTicket;
    private double prix;
    @Enumerated(EnumType.STRING)
    private Statut statut=Statut.ACTIF;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Match match;

}
