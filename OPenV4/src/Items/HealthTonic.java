package Items;

import java.awt.Color;
import java.awt.Graphics;

import Misc.Assets;

public class HealthTonic extends Item{
	public HealthTonic(int x,int y){
		init();
		this.x=x;
		this.y=y;
	}
	public void tick(){
		if(isTouching()){
			gS.player.life+=1;
			gS.items.remove(this);
		}
	}
	public void render(Graphics g){
		if(gS.debug){
			g.setColor(Color.yellow);
			g.drawRect(x,y,sx,sy);
		}
		g.drawImage(Assets.assets[2],x,y,sx,sy,null);
	}
}
