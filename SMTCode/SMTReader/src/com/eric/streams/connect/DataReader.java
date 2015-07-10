package com.eric.streams.connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/****************************************************************************
 * <b>Title</b>: InternetAccess.java <p/>
 * <b>Project</b>: WebCrescendo <p/>
 * <b>Description: </b> Put Something Here
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 26, 2015<p/>
 * @updates:
 ****************************************************************************/
public class DataReader {

	
	private URL websiteURL;
	private URLConnection connector;
	private String html = "";
	
	
	public DataReader(String url) throws IOException{
		this.websiteURL = new URL(url);
		connector = this.websiteURL.openConnection();
		connector.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:38.0) Gecko/20100101 Firefox/38.0");
	}
	
	/**
	 * Reads the HTML code off of a website and stores it in a new file
	 * @param fileName name of the file the HTML is stored in
	 */
	public void readData(){
			BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(connector.getInputStream()));
			String inputLine;
			while((inputLine = in.readLine()) != null){
				html+=(inputLine + "\n");
			}
			in.close();
		}
		
		catch(Exception e){
			System.out.println(e);
		}
	}
	public String getHtml(){
		return html;
	}
}
