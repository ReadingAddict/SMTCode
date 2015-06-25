import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/****************************************************************************
 * <b>Title</b>: StreamObjectOne.java <p/>
 * <b>Project</b>: WebCrescendo <p/>
 * <b>Description: </b> Put Something Here
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 25, 2015<p/>
 * @updates:
 ****************************************************************************/
public class StreamObjectOne {

	String fileNameOne;
	String fileNameTwo;
	
	public StreamObjectOne(String fileNameOne, String fileNameTwo){
		this.fileNameOne = fileNameOne;
		this.fileNameTwo = fileNameTwo;
	}
	
	public FileReader readFile() throws IOException{
		File inputFile = new File(fileNameOne);
		FileReader in = new FileReader(inputFile);
		return in;
		
	}
	
	public FileWriter writeFile() throws IOException{
		File outputFile = new File(fileNameTwo);
		FileWriter out = new FileWriter(outputFile);
		
		return out;		
		
	}
	
}
