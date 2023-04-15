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

@Entity
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

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
