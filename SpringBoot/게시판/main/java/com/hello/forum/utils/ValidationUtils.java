package com.hello.forum.utils;

/**
 * Spring Validator를 사용하지 않고
 * 파라미터 유효성 검사를 하기 위한 유틸리티
 */
public abstract class ValidationUtils {

	private ValidationUtils() {
		
	}
	
	// 비어있을때 false, 안비어있을 때 true
	public final static boolean notEmpty(String value) {
		return !StringUtils.isEmpty(value);
	}
	
	// email 포맷이면 true, 아니면 false
	public final static boolean email(String value) {
		return StringUtils.isEmailFormat(value);
	}
}
