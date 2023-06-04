package com.org.attendance.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super("Resource Name: %s is not found for %s : %d".formatted(resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	
}
