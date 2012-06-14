package com.mytwocents.json.StockRestTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mytwocents.StockRestTest.StockQuoteRetrieve;

public class JSonDriver {

	private static StockQuoteRetrieve sqRetriever;
	
	public static void main(String[] args) {
	  
      ApplicationContext appContext = new ClassPathXmlApplicationContext("app-jconfig.xml", JSonDriver.class);
	  sqRetriever = appContext.getBean(StockQuoteRetrieve.class);
	  sqRetriever.retrieveJson("FB");
		
	}
	
	
}