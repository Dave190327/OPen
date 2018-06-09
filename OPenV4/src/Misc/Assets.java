package Misc;

import java.awt.image.BufferedImage;
import java.io.File;
import Main.Game;

public class Assets {
	Game test=new Game();
	public static int x=1,y=1;
	public static BufferedImage[] assets=new BufferedImage[10];
	public static void init(){
		assets[0] = ImageLoader.loadImage("/Sprites/Zambie.png");
		assets[1] = ImageLoader.loadImage("/Sprites/ZambieF.png");
		assets[2] = ImageLoader.loadImage("/Sprites/HealthTonic.png");
		
		//File actual = new File("C:\\Users\\Soul327\\eclipse-workspace\\OPen\\res\\Sprites");
		//for( File f : actual.listFiles()){System.out.println( f.getName()+" "+f.getAbsolutePath());}
	}
}