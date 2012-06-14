package com.mytwocents.StockRestTest;

import java.util.List;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("results")
public class Result {

	@XStreamImplicit(itemFieldName="quote")
	private List<Quote> quote;
	

    Result() {
		
	}
	
  	public List<Quote> getQuote() {
		return quote;
	}

	public void setQuote(List<Quote> quote) {
		this.quote = quote;
	}

}
