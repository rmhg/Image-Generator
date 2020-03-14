package backend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.*;

import javax.imageio.ImageIO;

public class GetImg {
	URL url;
	String surl;
	BufferedImage img;
	public GetImg(String s)
	{
		try {
			url = new URL(s);
			img = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("Check At URl");
			//e.printStackTrace();
		}
	}
	public void OutImg(String imgdst)
	{
		
		try {
			ImageIO.write(img,"jpg",new File(imgdst));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
