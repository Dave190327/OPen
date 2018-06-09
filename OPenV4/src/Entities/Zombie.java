package Entities;
import java.awt.Color;
import java.awt.Graphics;

import Items.HealthTonic;
import Main.Game;
import Misc.Assets;

public class Zombie extends Entities{
	int con=-1;
	boolean flip=false;
	public Zombie(){
		switch((int)(Math.random()*4)){
		case 0:x=-sx;y=(int)(Math.random()*Game.height);break;
		case 1:x=Game.width;y=(int)(Math.random()*Game.height);break;
		case 2:x=(int)(Math.random()*Game.width);y=Game.height;break;
		case 3:x=(int)(Math.random()*Game.width);y=-sy;break;
		}
		init();
	}
	public Zombie(int x,int y){
		this.x=x;
		this.y=y;
		init();
	}
	public void init(){
		id=1;
		speed=2;
		sy=70+(int)(Math.random()*5);
		sy+=(int)(Math.random()*5);
		hp=(int)(Math.random()*2)+1;maxHp=hp;
		canDie=true;
		melee=true;
	}
	public void tick(){
		if(hp<1){
			if(Math.random()>.5){
				gameState.items.add(new HealthTonic(x,y));
			}
			gameState.obj.remove(this);
		}
		if((int)(Math.random()*2)==0){
		if(gameState.player.x<x){inertiaX=-speed;con=0;asset=1;}
		if(gameState.player.x>x){inertiaX=speed;con=1;asset=0;}
		if(gameState.player.y<y){inertiaY=-speed;con=2;}
		if(gameState.player.y>y){inertiaY=speed;con=3;}
		}else{
			if((int)(Math.random()*5)==0){
				switch(con){
				case 0:inertiaX=-speed;break;
				case 1:inertiaX=speed;break;
				case 2:inertiaY=-speed;break;
				case 3:inertiaY=speed;break;
				}
			}else{
				switch((int)(Math.random()*4)){
				case 0:inertiaX=-speed;break;
				case 1:inertiaX=speed;break;
				case 2:inertiaY=-speed;break;
				case 3:inertiaY=speed;break;
				}
			}
		}
		tickB();
	}
	public void render(Graphics g){
		if(gameState.debug){
			g.setColor(Color.black);
			g.drawRect(x,y,sx,sy);
		}
		drawHealthBar(g);
		g.drawImage(Assets.assets[asset],x,y,50,75,null);
	}
}
