package Weapons;
import java.awt.Font;
import java.awt.Graphics;

import GameState.GameState;
import Main.Game;
import Projectiles.BasicBullet;

public abstract class Weapons{
	public static GameState gS;
	public int dam=2,acc=95,pen=1,lv=1,fireRate=10,life=100,sz=10,bulletKick=1,gunKick=0;
	public int clipSize=2,clip=1;
	public double spray=2,speed=15,reloadSpeed=3,reloadTick=0;
	public boolean elemental=false,shotgun=false;
	public String name="";
	public void fire(int x,int y,int d){
		fire2(x,y,d);
	}
	public void fire2(int x,int y,int d){
		if(clip>0){
			if(!shotgun){clip--;}
			double temp=0;
			spray=(20/100.0)*(100-acc);
			temp=Math.random()*spray;
			if(Math.random()>.5){temp=-temp;}
			switch(d){
			case 0:gS.projectile.add(new BasicBullet(x,y,speed,temp,dam,pen,life,sz));gS.player.inertiaX-=gunKick;break;
			case 1:gS.projectile.add(new BasicBullet(x,y,temp,speed,dam,pen,life,sz));gS.player.inertiaY-=gunKick;break;
			case 2:gS.projectile.add(new BasicBullet(x,y,-speed,temp,dam,pen,life,sz));gS.player.inertiaX+=gunKick;break;
			case 3:gS.projectile.add(new BasicBullet(x,y,temp,-speed,dam,pen,life,sz));gS.player.inertiaY+=gunKick;break;
			}
		}
	}
	public void tick(){
		if(reloadTick!=0 | clip<1)
			reloadTick++;
		if(reloadTick>reloadSpeed*60){
			reloadTick=0;clip=clipSize;}
	}
	public void render(Graphics g){
		int temp=Game.height-10,fontSize=40;
		g.setFont(new Font("TimesRoman",Font.PLAIN,fontSize));
		//Upside down\/
		g.drawString(clip+" /"+clipSize,0,temp);temp-=fontSize;
		if(elemental){
			g.drawString("",0,temp);temp-=fontSize;
			g.drawString("",0,temp);temp-=fontSize;
		}
		g.drawString("Fire Rate:"+fireRate/60.0,0,temp);temp-=fontSize;
		g.drawString("Accurecy:"+acc+"%",0,temp);temp-=fontSize;
		g.drawString("Damage:"+dam,0,temp);temp-=fontSize;
		g.drawString(name,0,temp);temp-=fontSize;
	}
}
