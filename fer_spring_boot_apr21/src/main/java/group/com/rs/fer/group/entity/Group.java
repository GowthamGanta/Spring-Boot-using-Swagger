package com.rs.fer.group.entity;

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

import com.rs.fer.participant.Participant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "whatsapp_group")
public class Group {

	@Id
	@Column(name = "group_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "group_name")
	private String groupName;

	public Group() {

	}

	public Group(int userId, String groupName) {
		this.userId = userId;
		this.groupName = groupName;
	}

	@OneToMany(targetEntity = Participant.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "group_id", referencedColumnName = "group_id")
	private Set<Participant> participants;

}
