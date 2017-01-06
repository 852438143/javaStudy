package com.ylw.Introspector;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


//内省 和反射一样都是框架里面的，学完框架需要去深入学习下
public class IntrospectorDemo {
	
	@Test
	public void test() throws IntrospectionException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		BeanInfo bi = Introspector.getBeanInfo(People.class);
		//或者調用getBeanInfo(People.class,Object.class);去掉Object屬性
		
		BeanDescriptor bdp = bi.getBeanDescriptor();
		//獲取該bean的Class對象
		Class beanClass = bdp.getBeanClass();
		//初始化一個People對象
		People people = (People) beanClass.newInstance();
		people.setAge(12);
		System.out.println(people);
		
		//方法
		System.out.println("獲取方法");
		MethodDescriptor[] mdps = bi.getMethodDescriptors();
		List<Method> ms = new ArrayList<Method>();
		for(MethodDescriptor mdp :mdps){
			ms.add(mdp.getMethod());
			System.out.println(mdp.getName());
		}
		
		//屬性
		System.out.println("獲取屬性");
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
			if(pd.getName().equals("name"))
				pd.getWriteMethod().invoke(people, "ylw");
		}
		System.out.println(people);
	}

}

class People{
	private String name;
	private String id;
	private int age;
	
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(String name, String id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	
}
