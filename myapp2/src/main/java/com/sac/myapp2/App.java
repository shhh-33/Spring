package com.sac.myapp2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       m4();
    }

    private static void m4() {
    	ApplicationContext ctx =new ClassPathXmlApplicationContext("aop.xml");
    	CoffeeShop coffee =ctx.getBean("coffeeShop",CoffeeShop.class);
    	coffee.divaa(0, 0);
    }
    
    private static void m3() {
    	ApplicationContext ctx =new ClassPathXmlApplicationContext("di2.xml");
    	BookVO2 book1=ctx.getBean("bookVO2",BookVO2.class);
    	System.out.println(book1);
    }
    
    
    
    
    private static void m2() {
    	
    	ApplicationContext ctx =new ClassPathXmlApplicationContext("d1.xml");
    	BookVO book1=(BookVO)ctx.getBean("book");
    	System.out.println(book1);
    }
    
    
	private static void m1() {
		BookVO book1 = new BookVO();
		BookVO book2 = new BookVO(0,null,null,null,null);
		System.out.println(book1);
		System.out.println(book2);
		
	}
}
