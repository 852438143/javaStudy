package com.ylw.classloaderDemo;

import org.junit.Test;

//雙親委派機制，先父類加載，在子類加載
//
public class ClassLoaderDemo {
	@Test
	public void test01(){
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//是引導類加載器bootstrap，沒有繼承ClassLoader所以為null
		
		System.out.println(System.getProperty("java.class.path"));
	}
	
}
