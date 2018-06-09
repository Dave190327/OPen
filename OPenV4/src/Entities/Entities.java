package Entities;
import java.awt.Color;
import java.awt.Graphics;

import GameState.GameState;
public abstract class Entities {
	public int x=0,y=0,sx=50,sy=50,ec=-1,speed=10,hp=10,maxHp=10,asset=0,weight=10;
	public int id=-1;
	public int inertiaX=0,inertiaY=0;
	public boolean canDie=false;
	public boolean melee=false;
	public static GameState gameState;
	public void tick(){}
	public void tickB(){
		x+=inertiaX;
		y+=inertiaY;
		if(inertiaX>0){
			inertiaX-=weight;
			if(inertiaX<0){
				inertiaX=0;
			}
		}
		if(inertiaX<0){
			inertiaX+=weight;
			if(inertiaX>0){
				inertiaX=0;
			}
		}
		if(inertiaY>0){
			inertiaY-=weight;
			if(inertiaY<0){
				inertiaY=0;
			}
		}
		if(inertiaY<0){
			inertiaY+=weight;
			if(inertiaY>0){
				inertiaY=0;
			}
		}
	}
	public void render(Graphics g){}
	public void drawHealthBar(Graphics g){
		int temp=(int)(hp*(50.0/maxHp));
		g.setColor(Color.GREEN);
		g.fillRect(x,y-20,temp,10);
		g.setColor(Color.WHITE);
		g.drawRect(x,y-20,sx,10);
	}
	public void die(){}
}
