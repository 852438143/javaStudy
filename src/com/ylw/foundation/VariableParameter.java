package com.ylw.foundation;

import org.junit.Test;

/*
 * 可变参数*/
public class VariableParameter {
	@Test
	public void testsum(){
		System.out.println(sum(1,2,3,4));
	}
	public int sum(int ...nums){
		int sum = 0;
		for(int i :nums){
			sum+=i;
		}
		return sum;
	}
}
