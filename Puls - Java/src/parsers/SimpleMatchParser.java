package parsers;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import framework.CSVFileManager;
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
		System.out.println();
		}
		System.out.println("SimpleMatchParser.parse(for:"+forloops+",while:"+whileloops+") -> " + tokens + ";");
		return tokens;
	}

	public static void main(String[] args) throws IOException {
		//this test looks for the text surrounded by <b> and </b> and creates token for every success (1).
//		String txt = "Hallo du schoene Welt, wie geht es <b>dir</b> heute? Hast du gut geschlafen oder nicht?";
//        List<TokenType> types = new Vector<TokenType>();
//        types.add(new TokenType("everything bold", "<b>.*</b>", "catches everything in <b> tags" ));
//        types.add(new TokenType("Hallo" , "Hallo .* Welt", "lalala"));
		
		String txt = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">					<tr>				<td class=\"spacer\">&nbsp;				</td>			</tr>				<tr><td class=\"klein\">				      												        	        		        		<a href=\"https://puls.uni-potsdam.de/qisserver/rds;jsessionid=1A46247C2820F88217B918DADD4B1FC4.node11?state=verpublish&amp;status=init&amp;vmfile=no&amp;publishid=25765&amp;moduleCall=webInfo&amp;publishConfFile=webInfo&amp;publishSubDir=veranstaltung\" hreflang=\"de\" charset=\"ISO-8859-1\" title=\"Gruppe 2 UNIcert III/2 Englisch der Wirtschaftswissenschaften\" class=\"ver\">    				Gruppe 2 UNIcert III/2 En...    			</a>    		    					    									    			        </td></tr>        <tr><td class=\"notiz\">	        4 SWS&nbsp;&nbsp; englisch&nbsp;&nbsp;        </td></tr>				<tr>			<td class=\"notiz\" colspan=\"2\">									Donnerstag,&nbsp;								08:00 - 10:00, wöchentlich			</td> 		</tr>					<tr>				<td class=\"notiz\" colspan=\"2\">Start :&nbsp;&nbsp;20.10.2011				</td>			</tr>							<tr>					<td class=\"notiz\" colspan=\"2\">Ende :&nbsp;&nbsp;09.02.2012					</td>				</tr>				<tr>					<td class=\"notiz\" colspan=\"2\">Übung; &nbsp; &nbsp;					 Raum : 3.06.1.19</td>				</tr>															<tr>							<td class=\"notiz\" colspan=\"2\">Lehrperson :																									 																														Lüer &nbsp; 																																																																				</td>						</tr>									                									<tr>						<td class=\"notiz\">																								Einrichtung:																																		<a href=\"https://puls.uni-potsdam.de/qisserver/rds;jsessionid=1A46247C2820F88217B918DADD4B1FC4.node11?state=verpublish&amp;status=init&amp;vmfile=no&amp;moduleCall=webInfo&amp;publishConfFile=webInfoEinrichtung&amp;publishSubDir=einrichtung&amp;einrichtung.eid=40\"  class=\"ver\">																	Zessko - Bereich Sprachen																			- Zentrale Einrichtung																	</a>													</td>					</tr>																            	            				        					        						    <tr><td class=\"klein\">  <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" class=\"tablebox\">  <colgroup>        <col width=\"1*\">        <col width=\"1*\">        <col width=\"2*\">        <col width=\"2*\">        <col width=\"1*\">        <col width=\"1*\">  </colgroup>  <tr class=\"plan_rahmen\" style=\"padding-left:2px; padding-right:2px;\">	  <td align=\"center\" class=\"kleinFett\">		  		                            			        <span title=\"zugelassen\">ZU</span>											</td>          <td class=\"kleinFett\" nowrap title=\"Belegung &uuml;ber PULS\" align=\"center\">B</td>            <td class=\"klein\" align=\"center\" style=\"white-space: nowrap; padding-left: 2px; padding-right: 2px;\">      				              <a class=\"nav\" href=\"https://puls.uni-potsdam.de/qisserver/rds;jsessionid=1A46247C2820F88217B918DADD4B1FC4.node11?state=wwrite&amp;write=look&amp;from=out&amp;par=old&amp;add.25765=2&amp;asi=uRppbN89LUs455u7uJxc\">abmelden</a>			<input type=\"Hidden\" name=\"add.25765\" value=\"2\">          		          </td>               <td class=\"klein\" align=\"center\" nowrap>                   <a class=\"nav\" href=\"https://puls.uni-potsdam.de/qisserver/rds;jsessionid=1A46247C2820F88217B918DADD4B1FC4.node11?state=wwrite&amp;write=info&amp;from=out&amp;par=old&amp;add.25765=2&amp;asi=uRppbN89LUs455u7uJxc\">Information</a>              </td>              		      <td align=\"center\" class=\"klein\" title=\"aus Ansicht entfernen\">    <a href=\"https://puls.uni-potsdam.de/qisserver/rds;jsessionid=1A46247C2820F88217B918DADD4B1FC4.node11?state=wplan&amp;search=ver&amp;act=rem&amp;show=plan&amp;Vid=25765&amp;Gid=2\" class=\"tree\">    <img src=\"/QIS/images//X.gif\" alt=\"[l&ouml;schen]\" border=\"0\" height=\"10\"></a>    </td>  	          <td><input type=\"Hidden\" name=\"add.25765\" value=\"2\"></td>    </tr>  </table></td></tr>        					        				    									</table>";
//		List<TokenType> types = new Vector<TokenType>();
//		types.add(new TokenType("Notiz", "<td class=\"notiz\" colspan=\"2\">.*</td>", "Anfangs + Endzeit, Häufigkeit der Termine"));
		CSVFileManager csvMgr = new CSVFileManager();
		SimpleMatchParser parser = new SimpleMatchParser(TokenType.parse(csvMgr
				.readFile("res/pulsSheduleObjects.txt").getCSVObject()));
        for(Token t : parser.parse(txt)){
		String txt = "Hallo du schoene Welt, wie geht es <b>dir</b> heute? Hast du gut geschlafen oder nicht?";
        List<TokenType> types = new Vector<TokenType>();
        types.add(new TokenType("everything bold", "<b>.*</b>", "catches everything in <b> tags"));
        
        for(Token t : (new SimpleMatchParser(types)).parse(txt)){
        	System.out.println(t);
        }
		
	}

}
