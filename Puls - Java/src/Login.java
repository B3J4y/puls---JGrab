import java.io.*;
import java.net.*;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;

import writers.SimpleTextWriter;


public class Login {

	public Login() {
		connectPuls();
	}
	
	public void connectPuls(){
//		try {
//			DefaultHttpClient client = new DefaultHttpClient();
//			HttpPost post = new HttpPost("https://puls.uni-potsdam.de/qisserver/rds?state=user&type=1&asdf=jbernoth&fdsa=bl4bl411&category=auth.login&startpage=portal.vm");
//			HttpResponse res = client.execute(post);
//			System.out.println(res.toString());
//		} catch (Exception e){
//			System.out.println(e.getMessage());
//		}
		
		try {
			//login Link
//			URL url = new URL("https://puls.uni-potsdam.de/qisserver/rds?state=user&type=1&asdf=jbernoth&fdsa=bl4bl411&category=auth.login&startpage=portal.vm");
//			URL url = new URL("https://puls.uni-potsdam.de/qisserver/rds;jsessionid=A36DD10F314208090387B82456C55B2C.node11?state=wplan&amp;week=-2&amp;act=show&amp;pool=&amp;show=liste&amp;P.vx=lang&amp;P.subc=plan");
//			URL url = new URL("https://puls.uni-potsdam.de/qisserver/rds;jsessionid=B991BAC6341E5589790CD58A3910E40E.node11?state=verpublish&amp;status=init&amp;vmfile=no&amp;publishid=25196&amp;moduleCall=webInfo&amp;publishConfFile=webInfo&amp;publishSubDir=veranstaltung");
			//Stundplan lang link
//			URL url = new URL("https://puls.uni-potsdam.de/qisserver/rds;jsessionid=B991BAC6341E5589790CD58A3910E40E.node11?state=wplan&week=-2&act=show&pool=&show=plan&P.vx=lang&P.subc=plan");
			//Wochenansicht
//			URL url = new URL("https://puls.uni-potsdam.de/qisserver/rds;jsessionid=1A46247C2820F88217B918DADD4B1FC4.node11?state=wplan&value=43_2011&act=show&pool=&show=plan&P.vx=lang&P.subc=plan&week=51_2011");
			URL url = new URL("http://pro5.wi.uni-potsdam.de:8080/studiUpServer/puls");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod( "GET" );
//			connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//			connection.setRequestProperty("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
//			connection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
//			connection.setRequestProperty("Accept-Language", "de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4");
//			connection.setRequestProperty("Cache-Control", "max-age=0");
//			connection.setRequestProperty("Cache-Control", "max-age=0");
//			connection.setRequestProperty("Connection", "keep-alive");
//			connection.setRequestProperty("Content-Length", "29");
//			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//			connection.setRequestProperty("Cookie", "__utma=221810396.706524385.1312495184.1312495184.1328097894.2; __utmz=221810396.1328097894.2.2.utmcsr=mentoring-brandenburg.de|utmccn=(referral)|utmcmd=referral|utmcct=/");
//			connection.setRequestProperty("Host", "puls.uni-potsdam.de");
//			connection.setRequestProperty("Origin" , "null");
//			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.77 Safari/535.7");
			OutputStream out = new FileOutputStream("res/index.html");
			BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()) );
			SimpleTextWriter writer = new SimpleTextWriter();
			String output ="";
			for ( String line; (line = reader.readLine()) != null; )
			{
				output+=line;
				System.out.println(line);
			}
//			writer.writeFile(output,System.getProperty("user.home")
//					+ "\\Documents\\le.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Login();
	}

}
