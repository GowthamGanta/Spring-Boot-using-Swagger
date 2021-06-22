package com.rs.fer.util;

import java.util.Set;

import org.springframework.util.StringUtils;

public class FERUtil {

	public static Set<String> addErrorIfEmpty(Set<String> errorMessages, Object value, String errorMessage) {

		if (StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		} else if ((value instanceof Integer && Integer.parseInt(value.toString()) <= 0)
				|| (value instanceof Float && Float.parseFloat(value.toString()) <= 0)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

}
