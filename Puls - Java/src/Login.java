import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.*;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;


public class Login {

	public Login() {
		// TODO Auto-generated constructor stub
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
//			URL url = new URL("https://puls.uni-potsdam.de/qisserver/rds?state=user&type=1&asdf=jbernoth&fdsa=bl4bl411&category=auth.login&startpage=portal.vm");
			URL url = new URL("https://puls.uni-potsdam.de/qisserver/rds;jsessionid=A8846CE175C06127D03537F63E13DA8D.node11?state=wplan&amp;week=-2&amp;act=show&amp;pool=&amp;show=liste&amp;P.vx=lang&amp;P.subc=plan");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod( "GET" );
			BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()) );

			for ( String line; (line = reader.readLine()) != null; )
			{
				System.out.println( line );
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
