package com.rs.fer.ipl.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.PlayerRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.DeletePlayerRequest;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;
import com.rs.fer.ipl.response.DeletePlayerResponse;
import com.rs.fer.ipl.response.GetPlayerResponse;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.response.UpdatePlayerResponse;
import com.rs.fer.ipl.util.PlayerUtil;

@SpringBootTest

public class PlayerServiceImplTest {
	@InjectMocks
	private PlayerServiceImpl playerServiceImpl;

	@Mock
	PlayerRepository playerRepository;
	@Mock
	TeamRepository teamRepository;

	@Mock
	PlayerUtil playerUtil;

	@Test
	public void testSavePlayer() {

		List<Player> player = new ArrayList<>();
		Team team = new Team();
		Player players = new Player();
		team.setPlayers(new LinkedHashSet<Player>());

		players.setPlayerId(1);
		Optional<Team> teamobj = Optional.of(team);
		// Mock
		when(playerRepository.findByJerseyNumber(Mockito.anyString())).thenReturn(player);
		when(teamRepository.findById(Mockito.anyInt())).thenReturn(teamobj);

		when(playerRepository.save(Mockito.any())).thenReturn(players);

		when(playerUtil.loadSavePlayerRequestToPlayer(Mockito.any())).thenReturn(players);

		// 1.
		SavePlayerRequest request = new SavePlayerRequest();
		request.setFirstName("virat");
		request.setLastName("kohli");
		request.setMiddleName("anushka");
		request.setGender('m');
		request.setDob("26-12-2000");
		request.setRole("M");
		request.setSpecilization("BA");
		request.setJerseyNumber("vk123");

		// 2.
		SavePlayerResponse response = playerServiceImpl.savePlayer(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testSavePlayerDuplicate() {

		List<Player> player = new ArrayList<>();
		Team team = new Team();
		Player players = new Player();
		team.setPlayers(new LinkedHashSet<Player>());

		players.setPlayerId(1);
		player.add(players);
		Optional<Team> teamobj = Optional.of(team);
		// Mock
		when(playerRepository.findByJerseyNumber(Mockito.anyString())).thenReturn(player);
		when(teamRepository.findById(Mockito.anyInt())).thenReturn(teamobj);

		when(playerRepository.save(Mockito.any())).thenReturn(players);

		when(playerUtil.loadSavePlayerRequestToPlayer(Mockito.any())).thenReturn(players);

		// 1.
		SavePlayerRequest request = new SavePlayerRequest();
		request.setFirstName("virat");
		request.setLastName("kohli");
		request.setMiddleName("anushka");
		request.setGender('m');
		request.setDob("26-12-2000");
		request.setRole("M");
		request.setSpecilization("BA");
		request.setJerseyNumber("vk123");

		// 2.
		SavePlayerResponse response = playerServiceImpl.savePlayer(request);

		// 3.
		assertEquals("001", response.statusCode);
	}

	@Test
	public void testSavePlayerFailure() {

		List<Player> player = new ArrayList<>();
		Team team = new Team();
		Player players = new Player();
		team.setPlayers(new LinkedHashSet<Player>());

		// players.setPlayerId(1);
		Optional<Team> teamobj = Optional.empty();
		// Mock
		when(playerRepository.findByJerseyNumber(Mockito.anyString())).thenReturn(player);
		when(teamRepository.findById(Mockito.anyInt())).thenReturn(teamobj);

		when(playerRepository.save(Mockito.any())).thenReturn(players);

		when(playerUtil.loadSavePlayerRequestToPlayer(Mockito.any())).thenReturn(players);

		// 1.
		SavePlayerRequest request = new SavePlayerRequest();
		request.setFirstName("virat");
		request.setLastName("kohli");
		request.setMiddleName("anushka");
		request.setGender('m');
		request.setDob("26-12-2000");
		request.setRole("M");
		request.setSpecilization("BA");
		request.setJerseyNumber("vk123");

		// 2.
		SavePlayerResponse response = playerServiceImpl.savePlayer(request);

		// 3.
		assertEquals("002", response.statusCode);
	}

	@Test
	public void testDeletePlayer() {
		int playerId = 0;
		Player player = new Player();
		player.setPlayerId(1);
		Optional<Player> playerObj = Optional.of(player);

		when(playerRepository.findById(Mockito.anyInt())).thenReturn(playerObj);
		when(playerRepository.save(Mockito.any())).thenReturn(playerObj);

		DeletePlayerRequest request = new DeletePlayerRequest();
		request.setPlayerId(1);

		// 2.
		DeletePlayerResponse response = playerServiceImpl.deletePlayer(playerId);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testDeletePlayerFailure() {
		int playerId = 0;
		// player.setPlayerId(1);
		Optional<Player> playerObj = Optional.empty();
		// errorMessages.add("please enter Id");

		when(playerRepository.findById(Mockito.anyInt())).thenReturn(playerObj);
		when(playerRepository.save(Mockito.any())).thenReturn(playerObj);

		DeletePlayerRequest request = new DeletePlayerRequest();
		request.setPlayerId(1);

		// 2.
		DeletePlayerResponse response = playerServiceImpl.deletePlayer(playerId);

		// 3.
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testGetPlayerResponse() {
		Player player = new Player();
		player.setPlayerId(1);
		Optional<Player> players = Optional.of(player);

		when(playerRepository.findById(Mockito.anyInt())).thenReturn(players);

		int playerId = 1;

		GetPlayerResponse response = playerServiceImpl.getPlayer(playerId);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetPlayerNotFound() {

		Optional<Player> players = Optional.empty();

		// Team teams = new Team();
		// Mock
		when(playerRepository.findById(Mockito.anyInt())).thenReturn(players);

		// 2.
		int playerId = 0;
		GetPlayerResponse response = playerServiceImpl.getPlayer(playerId);

		// 3.
		assertEquals("002", response.statusCode);
	}

	@Test
	public void testUpdatePlayer() {

		Player player = new Player();
		List<Player> players = new ArrayList<>();
		player.setPlayerId(3);
		players.add(player);
		// Mock
		when(playerRepository.findByPlayerId(Mockito.anyInt())).thenReturn(players);

		when(playerRepository.save(Mockito.any())).thenReturn(player);

		when(playerUtil.laodUpdatePlayerRequestToPlayer(Mockito.any())).thenReturn(player);

		// 1.
		UpdatePlayerRequest request = new UpdatePlayerRequest();
		request.setPlayerId(3);
		request.setFirstName("Dhoni");
		request.setLastName("MS");
		request.setMiddleName("Mahi");
		request.setGender('M');
		request.setDob("26-12-1995");
		request.setRole("C");
		request.setSpecilization("BA");
		request.setJerseyNumber("7");

		// 2.
		UpdatePlayerResponse response = playerServiceImpl.updatePlayer(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testUpdatePlayerFailure() {

		List<Player> players = new ArrayList<>();

		Player player = new Player();
		// Mock
		when(playerRepository.findByPlayerId(Mockito.anyInt())).thenReturn(players);

		// when(playerRepository.save(Mockito.any())).thenReturn(player);

		when(playerUtil.laodUpdatePlayerRequestToPlayer(Mockito.any())).thenReturn(player);

		// 1.
		UpdatePlayerRequest request = new UpdatePlayerRequest();
		// request.setPlayerId(3);
		// request.setFirstName("virat");
		// request.setLastName("kohli");
		// request.setMiddleName("anushka");
		// request.setGender('m');
		// request.setDob("26-12-2000");
		// request.setRole("M");
		// request.setSpecilization("BA");
		// request.setJerseyNumber("vk123");

		// 2.
		UpdatePlayerResponse response = playerServiceImpl.updatePlayer(request);

		// 3.
		assertEquals("002", response.statusCode);
	}

}
