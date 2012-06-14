package com.mytwocents.StockRestTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	private static StockQuoteRetrieve sqRetriever;
	
	public static void main(String[] args) {
	  
      ApplicationContext appContext = new ClassPathXmlApplicationContext("app-config.xml", Driver.class);
	  sqRetriever = appContext.getBean(StockQuoteRetrieve.class);
	  sqRetriever.retrieve("FB");
		
	}
	
	
}