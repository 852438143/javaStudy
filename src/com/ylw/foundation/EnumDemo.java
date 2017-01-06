package com.ylw.foundation;

import org.junit.Test;
//枚举
public class EnumDemo {
	//测试基本的enum类;Garde
	@Test
	public void test1(){
		System.out.println(Grade.A);
		System.out.println(Grade.A.name());
	}
	
	//测试自己构造的enum类，Grade1
	@Test
	public void test2(){
		System.out.println(Grade1.A);//获取对象名称
		System.out.println(Grade1.A.name());//获取对象名称
		System.out.println(Grade1.A.getValue());//调用该类对象的方法
		System.out.println(Grade1.A.ordinal());//该对象在该类中的顺序
		System.out.println(Grade1.B.ordinal());
	}
	
	//常用方法
	@Test
	public void test3(){
		Grade1 g = Grade1.valueOf("B");
		System.out.println(g.getValue());
		g = Enum.valueOf(Grade1.class, "C");
		System.out.println(g.getValue());
		Grade1[] gs = Grade1.values();
		for(Grade1 t: gs){
			System.out.println(t);
		}
	}
}

//枚举的基本类
enum Grade{
	A,B,C,D,E;//A,B,C,D,E是Garde类五个对象，使用的是默认构造方法Grade();
	//也可以用一个构造函数初始化A("90-100");
	//等价于 public static fianle Grade A = new Grade();
}

//自己定义的构造函数
enum Grade1{
	A("90-100"),B("80-89"),C("70-79"),D("60-69"),E("0-59");
	
	private String value;
	//为对象声明构造函数
	Grade1(String value ){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	
}
