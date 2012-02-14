package framework;

import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 * describes what you are looking for with a name, a regular expression (pattern) and a human readable description.
 * 
 * @author sholvar
 *
 */
public class TokenType {
	
	public final String name;
	
	public final Pattern pattern;
	
	public final String description;
		
	/**
	 * 
	 * @param name helps to identify the type
	 * @param pattern describes as a Java regular expression, what a token of this type should look like
	 * @param description describes in a human readable way, what this token should include
	 */
	public TokenType(String name, String pattern, String description){
		this.name = name;
		this.pattern = Pattern.compile(pattern);
		this.description = description;
	}
	
	/**
	 * read the configuration to create the tokentype objects
	 * not to be confused with the actual reading and searching in the original text to find the patterns described in the text.
	 * @param csv
	 * @return
	 */
	public static List<TokenType> parse(CSVObject csv){
		List<TokenType> types = new Vector<TokenType>();
		types = new Vector<TokenType>();
		String[][] data = csv.getData();
		for(String[] line : data){
			types.add(new TokenType(line[0], line[1], line[2]));
		}
		System.out.println("TokenType.parse() -> " + types + ";");
		return types;
	}

	@Override
	public String toString() {
		return "{ \"name\" : \"" + name + "\", \"pattern\" : \"" + pattern
				+ "\", \"description\" : \"" + description + "\"}";
	}
	
	public static void main(String[] args) {
		CSVObject csv = new CSVObject(3);

		//creates a cvs object like this:
		//a,b,c
		//d,e,f
		csv.addValueToLine("a")
		   .addValueToLine("b")
		   .addValueToLine("c")
		   .addLine()
		   .addValueToLine("d")
		   .addValueToLine("e")
		   .addValueToLine("f");
		
		System.out.println(parse(csv));
	}

}
