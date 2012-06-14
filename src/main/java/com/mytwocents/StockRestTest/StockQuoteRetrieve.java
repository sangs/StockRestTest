package com.mytwocents.StockRestTest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.*;

import javax.xml.transform.Source;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.mytwocents.json.StockRestTest.Wrapper;
import com.thoughtworks.xstream.XStream;

//import com.mytwocents.json.StockRestTest.query;




@Controller
public class StockQuoteRetrieve {
	
	 
	  private final RestTemplate rTemplate;
	
	  @Autowired
	  StockQuoteRetrieve(RestTemplate restTpl) {
	    rTemplate = restTpl;  
	  }
	  
	
	  public void retrieveJson(String requestedSymbol) {
	    ClientHttpRequestInterceptor clientHttpReqInterceptor = new AcceptHeaderHttpRequestInterceptor();
		List<ClientHttpRequestInterceptor> interceptors = Collections.singletonList(clientHttpReqInterceptor);
		rTemplate.setInterceptors(interceptors);
		
		doYQLQueryJson(requestedSymbol);
		return;  
	  }
	  
	  
	  private void doYQLQueryJson(String requestedSymbol) {
		  String env = "store://datatables.org/alltableswithkeys";
		  String fmt = "json";
		  requestedSymbol = "FB";
		  String requestedSymbol2 = "GOOG";
		  String symbolString = "("+"\""+requestedSymbol+"\""+",\""+requestedSymbol2+"\""+")";
						
		  String queryStr = "SELECT * from yahoo.finance.quotes where symbol in "; ////String query = "SELECT * from yahoo.finance.quotes where symbol = ";
		  String restJsonUrl = "http://query.yahooapis.com/v1/public/yql?q={qid}{symbol}&format={fmt}&env={senv}";

		  ////YQL query //////////
		  //--- JSON usage ---//
		  //Map<String, Object> response = rTemplate.getForObject(restJsonUrl, Map.class, query,symbolString,fmt,env);
		  //query response = rTemplate.getForObject(restJsonUrl, query.class, queryStr,symbolString,fmt,env);
		  Wrapper response = rTemplate.getForObject(restJsonUrl, Wrapper.class, queryStr,symbolString,fmt,env);
		  System.out.println("Received JSON response from YQL");
		  org.codehaus.jackson.map.ObjectMapper ObjMapper = new ObjectMapper();
		  try {
			ObjMapper.writeValue(new File("YQLJSonResponse.json"), response);
		  }
		  catch(Exception e) {
		    System.out.println(e.getMessage());
		  }
		  
		  
	  }
	  
	  
	  @SuppressWarnings("unchecked")
	  public void retrieve(String requestedSymbol) {
		ClientHttpRequestInterceptor clientHttpReqInterceptor = new AcceptHeaderHttpRequestInterceptor();
		List<ClientHttpRequestInterceptor> interceptors = Collections.singletonList(clientHttpReqInterceptor);
		rTemplate.setInterceptors(interceptors);
	
		//testURITemplate();
		doYQLQuery(requestedSymbol);
		//doCSVQuery(requestedSymbol);
	
		return;
	  }
	  
	  
	  private void doYQLQuery(String requestedSymbol) {
		XStream stream;
	    Source response = null;
		String env = "store://datatables.org/alltableswithkeys";
		requestedSymbol = "FB";
		String requestedSymbol2 = "GOOG";
		String symbolString = "("+"\""+requestedSymbol+"\""+",\""+requestedSymbol2+"\""+")";
					
		String queryStr = "SELECT * from yahoo.finance.quotes where symbol in "; ////String query = "SELECT * from yahoo.finance.quotes where symbol = ";
		String restUrl = "http://query.yahooapis.com/v1/public/yql?q={qid}{symbol}&env={senv}";

		////YQL query //////////
		
		//---- SourceHttpMessageConverter usage ----////
		response = rTemplate.getForObject(restUrl, Source.class, queryStr,symbolString,env); //(url, responseType, urlVariables), 
		parseAndProcessSource(response);
		
		//--- XStream usage ------//
		/*Query response = rTemplate.getForObject(restUrl, Query.class, queryStr,symbolString,env);
		
		System.out.println("Received response from YQL!");
		stream = new XStream();
		System.out.println(stream.toXML(response));
			*/	
	
	  }
	  
	  private void doCSVQuery(String requestedSymbol) {
		String symbolString = "\""+requestedSymbol+"\"";
		requestedSymbol = "FB";
		
	    ///// CSV Format /////
		String restUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=FB&f=sd1op&e=.csv";

		byte[] response = rTemplate.getForObject(restUrl, byte[].class);
		String csvResponse = new String(response);
			
		System.out.println("Received response from YQL!");
		System.out.println("Response " + csvResponse + " received from Yahoo finance!");  
	  }
	  
	  private void parseAndProcessSource(Source response) {
		  
	  }
	  
	  private void testURITemplate() {
		//yahoo.finance.stocks, quotes
		String hostName = "http://query.yahooapis.com/v1/public/yql";
		URI queryURI;
		String fmt = "json";
		String requestedSymbol = "FB";
		String requestedSymbol2 = "APPL";
		String env = "store://datatables.org/alltableswithkeys";
		String symbolString = "("+"\""+requestedSymbol+"\""+",\""+requestedSymbol2+"\""+")";
	    //String query = "SELECT * from yahoo.finance.quotes where symbol = ";
		String queryStr = "SELECT * from yahoo.finance.quotes where symbol in ";
		//String restQuery = "http://query.yahooapis.com/v1/public/yql?q={qid}{symbol}&env={senv}";
		String restQuery="http://query.yahooapis.com/v1/public/yql?q={qid}{symbol}&format={fmt}&env={senv}";
		
		UriTemplate template = new UriTemplate(restQuery);
		String restUrl = (template.expand(queryStr,symbolString,fmt,env)).toString();
		System.out.println(restUrl); 
	  }
	  
	  
	  class AcceptHeaderHttpRequestInterceptor implements ClientHttpRequestInterceptor {
        String acceptHeaderValue;
		  
        AcceptHeaderHttpRequestInterceptor() {
        	
        }
        
		AcceptHeaderHttpRequestInterceptor(String headerValue) {
			acceptHeaderValue = headerValue;
		}
		  
		  
		@Override
		public ClientHttpResponse intercept(HttpRequest request, byte[] body,
				ClientHttpRequestExecution execution) throws IOException {
		  //request.getHeaders().setContentType(mediaType)
		  List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		  acceptableMediaTypes.add(MediaType.valueOf("application/xml"));
		  acceptableMediaTypes.add(MediaType.TEXT_XML);
		  acceptableMediaTypes.add(MediaType.valueOf("application/json"));
		  acceptableMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
		  HttpRequestWrapper rWrapper = new HttpRequestWrapper(request);
		  rWrapper.getHeaders().setAccept(acceptableMediaTypes);
			
		  return execution.execute(rWrapper, body);
		}
		  
	  }
	  

	}
