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
@Table(name = "championship")
public class Championship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "host")
	private User host;

	@ManyToMany
	@JoinTable(
			name = "championship_soccer_team",
			joinColumns = @JoinColumn(name = "championship_id"),
			inverseJoinColumns = @JoinColumn(name = "soccer_team_id"))
	private Set<SoccerTeam> soccerTeams;

}
