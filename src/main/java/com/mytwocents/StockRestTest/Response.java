package com.mytwocents.StockRestTest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonDeserialize;



public class Response {

	class Result {
		
	  @JsonIgnoreProperties(ignoreUnknown = true)
	  class Quote {
	    private String Symbol;
			
		private String LastTradeDate;
			
		private String Open; //double
			
		private String PreviousClose; //double
			
		private String Ask; //double
			
		private long AverageDailyVolume;

		public String getSymbol() {
			return Symbol;
		}

		public void setSymbol(String symbol) {
			Symbol = symbol;
		}

		public String getLastTradeDate() {
			return LastTradeDate;
		}

		public void setLastTradeDate(String lastTradeDate) {
			LastTradeDate = lastTradeDate;
		}

		public String getOpen() {
			return Open;
		}

		public void setOpen(String open) {
			Open = open;
		}

		public String getPreviousClose() {
			return PreviousClose;
		}

		public void setPreviousClose(String previousClose) {
			PreviousClose = previousClose;
		}

		public String getAsk() {
			return Ask;
		}

		public void setAsk(String ask) {
			Ask = ask;
		}

		public long getAverageDailyVolume() {
			return AverageDailyVolume;
		}

		public void setAverageDailyVolume(long averageDailyVolume) {
			AverageDailyVolume = averageDailyVolume;
		}
		
			
	  } //Quote
	  
	}   //Result
	
}		//Response
