package frontend;
import java.util.Vector;

import backend.Conn;
import backend.GetImg;

public class search {
    String keywords[];
    Conn conn;
    int i = 0;
    public search(String str,String dst)
    {
    	conn = new Conn("https://www.freeimages.com/search/" + str);
    	for(String k : conn.urls)
    	{
    		//System.out.println(k);
    		(new GetImg(k)).OutImg(dst + "" + i++ + ".jpg");
    	}
    }
}
