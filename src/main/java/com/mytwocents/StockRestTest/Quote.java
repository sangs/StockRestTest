package com.mytwocents.StockRestTest;

import java.util.Date;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;



//@XStreamOmitField

@XStreamAlias("quote")
public class Quote {
	
		
 	private String Symbol;
	
	private String LastTradeDate;
	
	private String Open; //double
	
	private String PreviousClose; //double
	
	private String Ask; //double
	
	private long AverageDailyVolume;
	
	private String Bid; //double
	
	private double AskRealtime;
	
	private double BidRealtime;
	
	private double BookValue;
	
	private String Change_PercentChange;
	
	private double Change;
	
	private String Commission;
    private double ChangeRealtime;
    private String AfterHoursChangeRealtime;
    private double DividendShare;
    //LastTradeDate;
    private String TradeDate;
    private double EarningsShare;
    private String ErrorIndicationreturnedforsymbolchangedinvalid;
    private double EPSEstimateCurrentYear;
    private double EPSEstimateNextYear;
    private double EPSEstimateNextQuarter;
    private String DaysLow;
    private String DaysHigh;
    private String YearLow;
    private double YearHigh;
    private String HoldingsGainPercent;
    private String AnnualizedGain;
    private String HoldingsGain;
    private String HoldingsGainPercentRealtime;
    private String HoldingsGainRealtime;
    private String MoreInfo;
    private String OrderBookRealtime;
    private String MarketCapitalization;
    private String MarketCapRealtime;
    private String EBITDA;
    private String ChangeFromYearLow;
    private String PercentChangeFromYearLow;
    private String LastTradeRealtimeWithTime;
    private String ChangePercentRealtime;
    private String ChangeFromYearHigh;
    private String PercebtChangeFromYearHigh;
    private String LastTradeWithTime;
    private double LastTradePriceOnly;
    private String HighLimit;
    private String LowLimit;
    private String DaysRange;
    private String DaysRangeRealtime;
    private double FiftydayMovingAverage;
    private double TwoHundreddayMovingAverage;
    private String ChangeFromTwoHundreddayMovingAverage; //double
    private String PercentChangeFromTwoHundreddayMovingAverage;
    private String ChangeFromFiftydayMovingAverage; //double
    private String PercentChangeFromFiftydayMovingAverage;
    private String Name;
    private String Notes;
    //private String Open;
    //PreviousClose
    private String PricePaid;
    private String ChangeinPercent;
    private String PriceSales; //double
    private String PriceBook; //
    private String ExDividendDate;
    private String PERatio; //double
    private String DividendPayDate;
    private String PERatioRealtime;
    private String PEGRatio; //double
    
    @XStreamOmitField
    private double PriceEPSEstimateCurrentYear;
    
    @XStreamOmitField
    private double PriceEPSEstimateNextYear;
    
    private String SharesOwned;
    private String ShortRatio;
    private String LastTradeTime;
    private String TickerTrend;
    
    @XStreamOmitField
    private double OneyrTargetPrice;
    
    private long Volume;
    private String HoldingsValue;
    private String HoldingsValueRealtime;
    private String YearRange;
    private String DaysValueChange;
    private String DaysValueChangeRealtime;
    private String StockExchange;
    private String DividendYield;
    String PercentChange;


	Quote() {
	  
	}
	
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
	
}
