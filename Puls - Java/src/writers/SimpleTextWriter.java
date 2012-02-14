package writers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * manages the writing to different streams in a simple way.
 * 
 * @author sholvar
 *
 */
public class SimpleTextWriter {

	/**
	 * write a text to a stream
	 * @param txt is the text to be written
	 * @param out is the stream, which can be anything from a file, the standardoutput, a websocket or something else
	 */
	public void write(String txt, OutputStream out) {
		PrintWriter printer = new PrintWriter(out);
		printer.print(txt);
		printer.flush();
	}

	/**
	 * a simplification of the write method to the StdOut.
	 * Does the same as System.out.print(txt);
	 * @param txt
	 */
	public void writeStdout(String txt) {
		write(txt, System.out);
	}

	/**
	 * writes to a file
	 * @param txt
	 * @param Filename
	 * @throws FileNotFoundException
	 */
	public void writeFile(String txt, String Filename) throws FileNotFoundException {
		write(txt, new FileOutputStream(new File(Filename)));
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//some tests
		String txt = "Hello Test\n";
		SimpleTextWriter writer = new SimpleTextWriter();
		writer.writeStdout(txt);
		System.out.println("finished");
	}

}
