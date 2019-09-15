package com.think.dog.util;

import java.io.InputStream;

public class ResourceUtils {
	
	private static ClassLoader loader;
	
	public static InputStream getResourceAsStream(String name) {
		if(loader==null) {
			loader = Thread.currentThread().getContextClassLoader();
		}
		return loader.getResourceAsStream(name);
	}
	
	public static InputStream getResourceAsStream(ClassLoader loader,String name) {
		return loader.getResourceAsStream(name);
	}
}
