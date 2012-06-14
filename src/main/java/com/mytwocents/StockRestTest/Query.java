package com.mytwocents.StockRestTest;


import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("query")
public class Query {

  @XStreamAlias("results")
  private Result result;
  
  
  Query() {
	  
  }
  
  public Result getResult() {
		return result;
  }

  public void setResult(Result result) {
		this.result = result;
  }

}
