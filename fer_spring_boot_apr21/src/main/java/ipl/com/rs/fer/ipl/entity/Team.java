package com.rs.fer.ipl.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Team {

	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;

	@Column
	private String name;

	@Column
	private String teamCode;

	@Column
	private String created;

	@Column
	private String updated;

	public Team() {

	}

	public Team(String name) {
		this.name = name;

	}

	@OneToMany(targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "t_id", referencedColumnName = "team_id")
	private Set<Player> players;

}
