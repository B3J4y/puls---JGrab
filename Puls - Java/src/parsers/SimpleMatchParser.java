package parsers;

import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import framework.Token;
import framework.TokenType;

/**
 * goes through a list of tokentypes and looks in a given text for tokens of these types.
 * 
 * @author sholvar
 *
 */
public class SimpleMatchParser {

	private List<TokenType> types = new Vector<TokenType>();

	public SimpleMatchParser(List<TokenType> types) {
		this.types = types;
	}

	/**
	 * creates a list of tokens according to a given text and according to it's list of tokentypes.
	 * @param txt is the text that should be searched for tokens
	 * @return a list of tokens that was found in the text
	 */
	public List<Token> parse(String txt) {
		List<Token> tokens = new Vector<Token>();
		int forloops = 0;
		int whileloops = 0;
		for (TokenType type : types) {
			forloops++;
			Matcher matcher = type.pattern.matcher(txt);
			whileloops = 0;
			while (matcher.find()) {
				whileloops++;
				tokens.add(new Token(type, matcher.group(), matcher.start(),
						matcher.end()));
			}
		}
		System.out.println("SimpleMatchParser.parse(for:"+forloops+",while:"+whileloops+") -> " + tokens + ";");
		return tokens;
	}

	public static void main(String[] args) {
		//this test looks for the text surrounded by <b> and </b> and creates token for every success (1).
		String txt = "Hallo du schoene Welt, wie geht es <b>dir</b> heute? Hast du gut geschlafen oder nicht?";
        List<TokenType> types = new Vector<TokenType>();
        types.add(new TokenType("everything bold", "<b>.*</b>", "catches everything in <b> tags"));
        
        for(Token t : (new SimpleMatchParser(types)).parse(txt)){
        	System.out.println(t);
        }
		
	}

}
