import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpGet {

	public static void main(String[] args) {
		
		new ReadByGet().start();

	}
	 static class ReadByGet extends Thread{
		@Override
		public void run() {
			try {
				
				URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=zyqtesthttpget&key=1803791190&type=data&doctype=xml&version=1.1&q=helloworld");
				URLConnection urlConnection = url.openConnection();
				InputStream iStream = urlConnection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(iStream,"UTF-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				
				String line;
				StringBuilder stringBuilder = new StringBuilder();
				while ((line=bufferedReader.readLine()) != null) {
					stringBuilder.append(line);
				}
				
				System.out.println(stringBuilder.toString());
			
			
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
