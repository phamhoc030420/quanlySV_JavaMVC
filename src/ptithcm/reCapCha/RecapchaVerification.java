package ptithcm.reCapCha;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import org.springframework.web.WebApplicationInitializer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;



public class RecapchaVerification {
	public static final String verificationurl="https://www.google.com/recaptcha/api/siteverify";
	public static final String secretkey="6Lc7nGYdAAAAAPM4yaeDbo9r0vYqRdk_pWqbzUED";
	public static final String USER_AGENT="Mozilla/5.0";
	public static boolean verify(String gRecaptchaResponse) throws IOException{
		if(gRecaptchaResponse== null||"".equals(gRecaptchaResponse)) {
			return false;
		}
		try {
			URL obj= new URL(verificationurl);
			HttpsURLConnection con=(HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent",USER_AGENT);
			con.setRequestProperty("Accept_Language", "en-US,en;q=0.5");
			String postParams="secret="+secretkey+"&response="+gRecaptchaResponse;
			con.setDoOutput(true);
			DataOutputStream wr= new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode= con.getResponseCode();
			
			BufferedReader in= new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response= new StringBuffer();
			while((inputLine=in.readLine())!=null) {
				response.append(inputLine);
			}
			in.close();
			//return true;
			JsonReader jsonReader=Json.createReader(new StringReader(response.toString()));
			JsonObject jsonObject=jsonReader.readObject();
			jsonReader.close();
			
			return jsonObject.getBoolean("success");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	
	
	
	
}
