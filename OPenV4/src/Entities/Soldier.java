package Entities;

import java.awt.Color;
import java.awt.Graphics;

import Items.HealthTonic;
import Main.Game;
import Misc.Assets;

public class Soldier extends Entities{
	int con=-1;
	boolean flip=false;
	public Soldier(){
		switch((int)(Math.random()*4)){
		case 0:x=-sx;y=(int)(Math.random()*Game.height);break;
		case 1:x=Game.width;y=(int)(Math.random()*Game.height);break;
		case 2:x=(int)(Math.random()*Game.width);y=Game.height;break;
		case 3:x=(int)(Math.random()*Game.width);y=-sy;break;
		}
		init();
	}
	public Soldier(int x,int y,int temp){
		ec=temp;
		this.x=x;
		this.y=y;
		init();
	}
	public void init(){
		id=2;
		speed=2;
		sy=75;
		canDie=true;
		melee=true;
	}
	public void tick(){
		tickB();
	}
	public void render(Graphics g){
		if(gameState.debug){
			g.setColor(Color.black);
			g.drawRect(x,y,sx,sy);
		}
		drawHealthBar(g);
		g.setColor(Color.orange);
		g.fillRect(x,y,sx,sy);
		//g.drawImage(Assets.assets[asset],x,y,50,75,null);
	}
}
