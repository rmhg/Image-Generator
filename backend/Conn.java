package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conn {
	Pattern p;
	Matcher m;
    URL url;
    public Vector<String> urls;
    String surl;
    URLConnection conn;
    BufferedReader src;
    String i;
    public Conn(String s)
    {
    	urls = new Vector<String>();
    	p = Pattern.compile("<img[^>]*src=\\\"?([^\\\"]*)\\\"?([^>]*alt=\\\"?([^\\\"]*)\\\"?)?[^>]*>");
    	try {
    	    
    		 url = new URL(s);
    		 surl = s;
    		 conn = url.openConnection();
    		 conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
    		 src = new BufferedReader(new InputStreamReader (conn.getInputStream())); 
        }
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	check();
    }   
    void check()
    {
    	try {
			while ((i = src.readLine()) != null)  
			{ 
				//System.out.println(i);
				m = p.matcher(i);
				if(m.find())
				{
					urls.add(m.group(1));
					
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
}
