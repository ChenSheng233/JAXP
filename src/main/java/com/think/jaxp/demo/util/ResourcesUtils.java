package com.think.jaxp.demo.util;

import java.io.InputStream;

public class ResourcesUtils {
	
	public static InputStream getResourceAsStream(String name) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
	}
}
