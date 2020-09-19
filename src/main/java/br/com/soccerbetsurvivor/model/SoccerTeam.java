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
public class SoccerTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo_path")
    private String logoPath;

    @ManyToMany(mappedBy = "soccerTeams")
    private Set<Championship> championships;

}



