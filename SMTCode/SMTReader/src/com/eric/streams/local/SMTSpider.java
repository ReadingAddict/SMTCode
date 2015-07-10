package com.eric.streams.local;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.eric.streams.connect.DataParser;




/****************************************************************************
 * <b>Title</b>: SMTSpider.java <p/>
 * <b>Project</b>: WebCrescendo <p/>
 * <b>Description: </b> Put Something Here
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jul 8, 2015<p/>
 * @updates:
 ****************************************************************************/
public class SMTSpider {

//	private String directoryName;
	private String url;
	private String[] args;
	private List<WebsiteVO> webs = new ArrayList<WebsiteVO>();
	
	
	public SMTSpider(String[] args) throws Exception{
		if(args.length == 2){
			System.out.println("Domain being Spidered: " + args[0] + " and the files are created in: " + args[1]);
		}else{throw new Exception("You entered the wrong number of parameters, please enter Domain and then Directory");}
		this.args = args;
		url = args[0];
//		directoryName = args[1];
	}
	
	public static void main(String[]args) throws Exception{
		new SMTSpider(args).go();
	}

	/**
	 * creates the original value object from the home page
	 * removes all the repeat home websites from the list
	 * calls the method to write all the files
	 * @throws IOException
	 */
	public void go() throws IOException{
		webs.add(new WebsiteVO(url, "/"));
		webs.get(0).setFileName("Home");
		
		DataParser dataParser = new DataParser();
		List<String> uris = dataParser.getUris(webs.get(0));
		for(String item : uris){
			webs.add(new WebsiteVO(url, item));
		}
		//have to be careful about skipping pieces of the list when doing removes
		int i = webs.size() -1;
		while(i >=1){
			if(webs.get(i).getUri().equals("/")){webs.remove(webs.get(i));}
			else{i--;}
		}
		
		for(WebsiteVO wv: webs){
			writeFile(wv);
		}
	}
	
	/**
	 * writes a website Value object to a file in the given directory
	 * Must be exact with the argument used to give the path name
	 * @param websiteVO the website Value Object being used to create the file
	 * @throws IOException
	 */
	public void writeFile(WebsiteVO websiteVO) throws IOException{
		File file = new File(args[1].toString() + websiteVO.getFileName().replace("/", " "));

		if(!file.exists()){
			file.createNewFile();
		}
		//certain writing tools work better than others
		PrintWriter printWriter = new PrintWriter(file);
		
		printWriter.println(websiteVO.toString());
		
		printWriter.close();
	}
		
}
