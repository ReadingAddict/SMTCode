package com.eric.streams.local;

import java.io.IOException;

import com.eric.streams.connect.DataReader;

/****************************************************************************
 * <b>Title</b>: WebsiteVO.java <p/>
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
public class WebsiteVO {

	private String fileName;
	private String domain;
	private String uri;
	private String html;
	
	public WebsiteVO(){}
	
	public WebsiteVO(String url, String uri) throws IOException{
		this.domain = url;
		this.uri = uri;
		this.fileName = uri;
		this.setHtml();
		System.out.println("A new VO was created with these properties");
		System.out.println("File Name: " + this.getFileName());
		System.out.println("Domain Name: " +this.getDomain());
		System.out.println("URI: " +this.getUri());
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getUri() {
		return uri;
	}
	@Override
	public String toString() {
		return "A new VO was created with these properties\n WebsiteVO fileName= " + fileName + "\n domain= " + domain
				+ "\n uri= " + uri + "\n html= " + html + "\n";
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml() throws IOException {
		DataReader dataReader = new DataReader(domain + uri);
		dataReader.readData();
		this.html = dataReader.getHtml();
	}
}
