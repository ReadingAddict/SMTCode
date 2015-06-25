import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/****************************************************************************
 * <b>Title</b>: StreamObjectTwo.java <p/>
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
public class StreamObjectTwo {

	StreamObjectOne soo;
	
	public StreamObjectTwo(String fileName, String fileNameTwo){
		soo = new StreamObjectOne(fileName, fileNameTwo);
	}
	
	
	public static void main(String[]args) throws IOException{
		StreamObjectTwo sot = new StreamObjectTwo("src/file.txt", "src/outPutFile");
		sot.toUpperCase();
	}
	
	public void toUpperCase() throws IOException{
		FileReader in = soo.readFile();
		FileWriter out = soo.writeFile();
		
		int c;
		
		while((c = in.read())!=-1){
			out.write(c -32);
		}
		
		
		in.close();
		out.close();
		
	}
	
}
