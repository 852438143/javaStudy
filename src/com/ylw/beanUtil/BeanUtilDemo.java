package com.ylw.beanUtil;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.junit.Test;
//使用BeanUtil操作baen對象
//jar包 commons-beanutils;
//commons-logging
//媽蛋寫這個代碼的時候Date包導成sql裏面的啦；一個晚上臥槽

public class BeanUtilDemo {
	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException{
		People people = new People();
		BeanUtils.setProperty(people, "name", "ylw");
		BeanUtils.setProperty(people, "id", "007");
		BeanUtils.setProperty(people, "age", "17");//即使age是int數據類型，也會被轉化
		System.out.println(people);
		
	}
	
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException{
		
//		4.3 Defining Your Own Converters 定义自己的Converter
//		The ConvertUtils class supports the ability to define and register your own String --> Object conversions for any given Java class. Once registered, such converters will be used transparently by all of the BeanUtils methods (including populate()). To create and register your own converter, follow these steps: 
//		ConvertUtils类对任何Java类都支持定义和注册我们自己的String --> Object的转换。一旦注册了，这些Converter对于所有的BeanUtils的方法（包括populate()）都是可见的。想建立并注册我们自己的Converter，有以下几步：
		
//		* Write a class that implements the Converter interface. The convert() method should accept the java.lang.Class object of your application class (i.e. the class that you want to convert to, and a String representing the incoming value to be converted. 
//		写一个Converter接口的实现类。convert()方法应该接收java.lang.Class 类型的对象作为参数。（也就是说，一个参数代表我们想转换的类，另一个String参数代表将要被转换的输入值） 
//		* At application startup time, register an instance of your converter class by calling the ConvertUtils.register() method. 
//		在应用程序启动时，通过调用ConvertUtils.register()方法来注册一个converter类的实例。
		
		Converter converter = new Converter(){//一個接口不能直接創建一個對象，要實現裏面的方法

			@Override
			public <T> T convert(Class<T> type, Object value) {
				if(value==null)
					return null;
				if(!(value instanceof String)){
					throw new ConversionException("the value is not a String");
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-hh");
				try {
					return (T) sdf.parse((String) value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			
			}
			
		};
		//注冊一個converter
		ConvertUtils.register(converter, Date.class);
		
		People people = new People();
		BeanUtils.setProperty(people, "name", "ylw");
		BeanUtils.setProperty(people, "id", "007");
		BeanUtils.setProperty(people, "age", "17");

		
		//BeanUtils.setProperty(people, "date", "1996-12-2");//BeanUtils衹能實現8種基本數據類型的轉化
		//如果要實現Date數據類型的轉化，需要自己注冊一個轉化器 convertUtils,對所有的bean類適用
		//使用System.out.println(ConvertUtils.convert("1992-12-2", Date.class));衹是把這個對象轉化罷了，不是整個類
		BeanUtils.setProperty(people, "date", "1996-12-2");
		
		System.out.println(people);
	}
	
	
    @Test
    public void test3() throws Exception{
        String name = "yuli";
        int age = 18;
    	String birthday = "1980-09-09";
//        String birthday = "";

        People p = new People();

        //注册自定义日期转换器
        ConvertUtils.register(new Converter() {

            @Override
            public Object convert(Class type, Object value) {
                // TODO Auto-generated method stub
                if(value == null){
                    return null;
                }

                if(!(value instanceof String)){
                    throw new ConversionException("只支持String类型的转换");
                }

                String str = (String) value;

                if(str.trim().equals("")){
                    return null;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return  df.parse(str);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }, Date.class);

        BeanUtils.setProperty(p, "name", name);//只支持8种基本数据类型
        BeanUtils.setProperty(p, "age", age);
        BeanUtils.setProperty(p, "date", birthday);

        System.out.println(p.getName());
        System.out.println(p.getAge());
    }
}



