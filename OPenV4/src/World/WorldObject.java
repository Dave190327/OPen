package World;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class WorldObject{
	public int x,y,sx,sy;
	BufferedImage image;
	String name;
	public void render(Graphics g){
		if(image!=null){
			g.drawImage(image,x,y,sx,sy,null);
		}else{
			g.fillRect(x,y,sx,sy);
		}
		if(GameState.GameState.debug){
			int tempFontSize=20;
			g.setFont(new Font("TimesRoman",Font.PLAIN,tempFontSize));
			g.drawRect(x, y, sx, sy);
			g.drawString(name,x,tempFontSize+y);
		}
	}
}
