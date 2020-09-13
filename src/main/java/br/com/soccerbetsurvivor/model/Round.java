package br.com.soccerbetsurvivor.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "soccer_team")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Championship championship;

    @ManyToOne
    @JoinColumn(name = "home_team")
    private SoccerTeam homeTeam;

    @ManyToOne
    @JoinColumn(name = "guest_team")
    private SoccerTeam guestTeam;

    @Column(name = "round_number")
    private Integer roundNumber;

}



