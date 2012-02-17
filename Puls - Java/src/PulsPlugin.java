import java.util.List;
import java.util.Vector;

import parsers.SimpleMatchParser;
import framework.CSVFileManager;
import framework.Token;
import framework.TokenType;
import readers.SimpleHttpReader;


public class PulsPlugin {
	String answer;
	public PulsPlugin(String name, String password) {
		try {
			String pulsLogin= "https://puls.uni-potsdam.de/qisserver/rds?state=user&type=1&" +
					"asdf=" + name + "&fdsa="+ password + "&category=auth.login&startpage=portal.vm";
			answer = new SimpleHttpReader().readURL(pulsLogin);
		} catch (Exception e){
			answer = e.getMessage();
		}
	}
	
	public String getSessionId(){
		
		String resString ="";
		CSVFileManager csvMgr = new CSVFileManager();
		try {
			SimpleMatchParser parser = new SimpleMatchParser(TokenType.parse(csvMgr
					.readFile("res/SessionID.txt").getCSVObject()));
			List<Token> result = parser.parse(answer);
			System.out.println("------------ SessionID "+ result.get(0).content.split("=")[1].split("\\.")[0] +" ---------------");
			resString = result.get(0).content.split("=")[1].split("\\.")[0] ;
		} catch (Exception e){
			resString = e.getMessage();
		}

		return resString;
	}
	
	public Vector<String> getBelegung(String sessionID){
		Vector<String> resString = new Vector<String>();
		CSVFileManager csvMgr = new CSVFileManager();
		String stundenplan = "https://puls.uni-potsdam.de/qisserver/rds;jsessionid=" + sessionID + ".node11?state=wplan&amp;week=-2&amp;act=show&amp;pool=&amp;show=liste&amp;P.vx=lang&amp;P.subc=plan";
		try{
			answer = new SimpleHttpReader().readURL(stundenplan);
			SimpleMatchParser parser = new SimpleMatchParser(TokenType.parse(csvMgr
					.readFile("res/belegung.txt").getCSVObject()));
			List<Token> result = parser.parse(answer);
			for (Token tkn : result){
				System.out.println("--------------" + tkn.content.split("\"")[3]);
			}
		} catch (Exception e){
			System.out.println("++++++++++++ Link " + stundenplan);
			System.out.println("++++++++++++ Error " + e.getMessage());
			answer = e.getMessage();
		}
		
		
		
		return null;
	}
	
	public static void main(String[] args){
		PulsPlugin lePuls = new PulsPlugin("jbernoth", "bl4bl411");
		//System.out.println(lePuls.answer);
		String sessionID = lePuls.getSessionId();
		lePuls.getBelegung(sessionID);
//		System.out.println(lePuls.getSessionId());
		System.out.println("fertig.");
	}
	
}
