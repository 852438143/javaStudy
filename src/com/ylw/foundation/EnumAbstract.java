package com.ylw.foundation;

import org.junit.Test;

//枚举的抽象方法
public class EnumAbstract {
	@Test
	public void test(){
		System.out.println(Grade3.A.getValue());
		System.out.println(Grade3.C.getLocalValue());
	}
}
enum Grade3{
	//因为声明了抽象方法，所以Grade3是一个抽象类，不能直接创建对象，创建对象是要实现抽象方法
	A("90-100"){
		@Override
		public String getLocalValue() {
			// TODO Auto-generated method stub
			return "优";
		}
	},B("80-89"){
		@Override
		public String getLocalValue() {
			return "良";
		}
	},C("70-79"){

		@Override
		public String getLocalValue() {
			return "一般";
		}
		
	},D("60-69"){

		@Override
		public String getLocalValue() {
			return "菜";
		}
		
	};
	
	private String value;
	//为对象声明构造函数
	Grade3(String value ){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	//声明一个抽象方法
	public abstract String getLocalValue();
}
