package com.rs.fer.ipl.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.repository.PlayerRepository;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.service.impl.PlayerServiceImpl;
import com.rs.fer.ipl.util.PlayerUtil;

@SpringBootTest

public class PlayerServiceImplTest {
	@InjectMocks
	private PlayerServiceImpl playerServiceImpl;

	@Mock
	PlayerRepository playerRepository;

	@Mock
	PlayerUtil playerUtil;

	@Test
	public void testSavePlayer() {

		List<Player> player = new ArrayList<>();

		Player players = new Player();
		players.setPlayerId(1);

		// Mock
		when(playerRepository.findByJerseyNumber(Mockito.anyString())).thenReturn(player);

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

		Player players = new Player();
		players.setPlayerId(1);

		player.add(players);

		// Mock
		when(playerRepository.findByJerseyNumber(Mockito.anyString())).thenReturn(player);

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

		Player players = new Player();

		// Mock
		when(playerRepository.findByJerseyNumber(Mockito.anyString())).thenReturn(player);

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

}
