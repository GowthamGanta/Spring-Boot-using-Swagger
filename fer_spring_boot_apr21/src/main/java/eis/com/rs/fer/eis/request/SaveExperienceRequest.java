package com.rs.fer.eis.request;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class SaveExperienceRequest {
	private String firm;
	private String fromDate;

	private String toDate;
	private int eid;
	

}
