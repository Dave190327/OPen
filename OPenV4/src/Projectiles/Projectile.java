package Projectiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import Entities.Entities;
import GameState.GameState;
import Main.Game;

public abstract class Projectile {
	public int sx=50,sy=50,fontSize=50,dam=1,pen=1,life=100,size=10;
	double xs=0,ys=0,x=0,y=0;
	public static GameState gS;
	String status="";
	public ArrayList<Entities> aH=new ArrayList<Entities>();
	public void init(){gS=Entities.gameState;}
	public void tick(){
		life--;
		x+=xs;
		y+=ys;
		checkCol();
		if(life<0){gS.projectile.remove(this);}
	}
	public void render(Graphics g){
		if(GameState.debug){
			
		}
		g.setColor(Color.magenta);
		g.fillRect((int)x,(int)y,sx,sy);
		g.setFont(new Font("TimesRoman",Font.PLAIN,fontSize));
		g.drawString(status,0,fontSize*3);
	}
	public void checkCol(){
		if(x>Game.width|y>Game.height|x<-sx|y<-sy){gS.projectile.remove(this);}
		for(int x=0;x<gS.obj.size();x++){
			boolean hit=false;
			for(int y=0;y<aH.size();y++){
				if(gS.obj.get(x)==aH.get(y)){
					hit=true;
					break;
				}
			}
			if(!hit){
				int ex=gS.obj.get(x).x;
				int ey=gS.obj.get(x).y;
				int ex2=gS.obj.get(x).x+gS.obj.get(x).sx;
				int ey2=gS.obj.get(x).y+gS.obj.get(x).sy;
				if(sx+this.x>ex & this.x<ex2 & sy+y>ey & y<ey2){
					gS.obj.get(x).hp-=dam;
					aH.add(gS.obj.get(x));
					pen--;
					//gS.projectile.remove(this);break;
				}
				if(pen<1){
					gS.projectile.remove(this);
				}
			}
		}
	}
}
