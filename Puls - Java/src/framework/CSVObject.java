package framework;

import java.util.List;
import java.util.Vector;

/**
 * contains a CVS string (from a file) in an object representation as a List of all lines, containing an array of the actual values each.
 * 
 * @author sholvar
 *
 */
public class CSVObject {

	private int valuesPerLine;

	private List<String[]> allLines = new Vector<String[]>();
	private String[] actLine;
	private int lastIndex = 0;

	/**
	 * 
	 * @param valuesPerLine how many values should each line include. Look into the according CVS File to decide
	 */
	public CSVObject(int valuesPerLine) {
		this.valuesPerLine = valuesPerLine;
		this.addLine();
	}

	
	public CSVObject addLine() {
		//protect against multiple calls to addLine()
		if(actLine != null && lastIndex <= 0)
			return this;
		
		return addLineForced();
	}
	
	public CSVObject addLineForced() {
		actLine = new String[valuesPerLine];
		lastIndex = 0;
		allLines.add(actLine);
		return this;
	}

	public CSVObject addValueToLine(String value) {
		actLine[lastIndex] = value;
		lastIndex++;
		return this;
	}
	
	public String toString(){
		String txt = "[";
		
		for (String[] values : allLines) {
			String line = " [";
			for (String value : values) {
				line += " \"" + value + "\",";
			}
			txt += line.substring(0, line.length()-1) + " ],";
		}
		txt = txt.substring(0,txt.length()-1) + " ]";
		
		return txt;
	}

	public String toCSV() {
		String txt = "";
		for (String[] line : allLines) {
			for (String value : line) {
				txt += (value != null) ? "\"" + value + "\"," : "\"\",";
			}
			txt = txt.substring(0, txt.length() - 1) + "\n";
		}
		return txt;
	}
	
	public String[][] getData(){
		String[][] data = new String[allLines.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = allLines.get(i);
		}
		return data;
	}

	public static void main(String[] args) {
		CSVObject csv = new CSVObject(3);
		//create (empty or not existing values should be nulled):
		//a,b,c
		//d,e
		//f
		csv.addValueToLine("a")
		   .addValueToLine("b")
		   .addValueToLine("c")
		   .addLine()
		   .addValueToLine("d")
		   .addValueToLine("e")
		   .addLine()
		   .addValueToLine("f");
		
		System.out.println(csv);
	}
}
