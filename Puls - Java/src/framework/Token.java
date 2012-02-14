package framework;

/**
 * a Token is the representation of a successful result of a search process
 * For example if you look for "Fubar" in "Where the Fubar is my hello world?"
 * then there will be a Token created for the third word, beginning at the 10th character.
 *  
 * @author sholvar
 *
 */
public class Token {
	
	public final TokenType type;
	
	public final String content;
	
	public final int start, end;
	
	/**
	 * 
	 * @param type says, which of the different types was found
	 * @param content contains the actual string that was found
	 * @param start is the position in the original string where the token was found
	 * @param end is the position in the original string where the found token ends
	 */
	public Token(TokenType type, String content, int start, int end){
		this.type = type;
		this.content = content;
		this.start = start;
		this.end = end;
	}

	
	@Override
	public String toString() {
		return "{ \"type\" : " + type + ", \"content\" : \"" + content + "\", \"start\" : "
				+ start + ", \"end\" : " + end + "}";
	}

}
