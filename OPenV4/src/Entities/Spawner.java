package Entities;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;

public class Spawner extends Entities{
	int tick=0;
	public static boolean flip=false;
	public Spawner(){
		x=(int)(Game.width*Math.random());
		y=(int)(Game.height*Math.random());
	}
	public Spawner(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void tick(){
		tick++;
		if(tick>60){
			tick=0;
			gameState.createZombie();
			gameState.obj.get(gameState.obj.size()-1).x=x;
			gameState.obj.get(gameState.obj.size()-1).y=y;
		}
	}
	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillOval(x,y,sx,sy);
	}
}
