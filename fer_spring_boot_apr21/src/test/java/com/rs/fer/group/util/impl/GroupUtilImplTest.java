package com.rs.fer.group.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.request.SaveGroupRequest;

@SpringBootTest
public class GroupUtilImplTest {
	
	@InjectMocks
	private GroupUtilImpl groupUtilImpl;
	
	@Test
	public void loadSaveGroupRequest(){
		SaveGroupRequest request = new SaveGroupRequest();
		request.setGroupName("rs");
		request.setUserId(2);
		
		Group group = groupUtilImpl.loadSaveGroupRequest(request,2,"rs");
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (null != group.getGroupName() && 0 != group.getUserId());

		assertEquals(isExpectedEmpty, isActualEmpty);
	
		
	}
	
	@Test
	public void loadSaveGroupRequestFailure(){
		SaveGroupRequest request = new SaveGroupRequest();
		//request.setGroupName("rs");
		request.setUserId(2);
		
		Group group = groupUtilImpl.loadSaveGroupRequest(request,2,"rs");
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = (null != group.getGroupName() && 0 != group.getUserId());

		assertEquals(isExpectedEmpty, isActualEmpty);
	
		
	}

	

}
