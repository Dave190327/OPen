package Items;

import java.awt.Graphics;

import GameState.GameState;

public abstract class Item {
	public int x=0,y=0,sx=50,sy=50,id=0;
	public static GameState gS;
	public boolean dropped=true;
	public void init(){gS=Entities.Entities.gameState;}
	public boolean isTouching(){
		int px=gS.player.x;
		int py=gS.player.y;
		int px2=gS.player.x+gS.player.sx;
		int py2=gS.player.y+gS.player.sy;
		if(sx+x>px & x<px2 & sy+y>py & y<py2){
			return true;
		}
		return false;
	}
	public void render(Graphics g){}
	public void tick(){}
}
