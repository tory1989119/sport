package com.sport.common.util;

public class ValidatorUtil {
	private boolean valid;
	
	public ValidatorUtil() {
		
	}

	public ValidatorUtil(boolean valid) {
		setValid(valid);
	}
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
