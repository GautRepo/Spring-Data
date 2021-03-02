package com.nt.generator;

import java.util.UUID;

public class IDGenerator {
	
	public static String generateId() {
		return UUID.randomUUID().toString().substring(1, 10).replace("-", "");
	}

}
