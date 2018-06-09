package Entities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import Main.Game;
import Misc.KeyManager;
import Weapons.Pistol;
import Weapons.SMG;
import Weapons.Shotgun;
import Weapons.Sniper;
import Weapons.Weapons;

public class Player extends Entities{
	KeyManager keyManager=Game.keyManager;
	public int life=3,fontSize=50,tickA=0,tickB=0,lv=1,weaponSelected=0;
	public int tickC=0;
	public ArrayList<Weapons> weap=new ArrayList<Weapons>();
	String t="";
	public Player(){
		weap.add(new Shotgun());
		weap.add(new Pistol());
		weap.add(new SMG());
		weap.add(new Sniper());
		x=1000;
		y=1000;
		speed=5;
	}
	public void tick(){
		keyManager.tick();
		weap.get(weaponSelected).tick();
		if(keyManager.a){inertiaX=-speed;}
		if(keyManager.d){inertiaX=speed;}
		if(keyManager.w){inertiaY=-speed;}
		if(keyManager.s){inertiaY=speed;}
		if(tickC==0){
			if(keyManager.one&-1<weaponSelected-1){weaponSelected--;tickC++;}
			if(keyManager.three){gameState.createWeaponDrop();}
			if(keyManager.two&weap.size()>weaponSelected+1){weaponSelected++;tickC++;}
			if(keyManager.four){weap.remove(0);weap.add(new Sniper());tickC++;}
			//System.out.println(weaponSelected);
		}else if(tickC!=0){tickC++;}if(tickC>30){tickC=0;}
		if(keyManager.space){
			gameState.debug=!gameState.debug;
		}
		t=""+tickA;
		if(tickA==0){
			boolean flip=false;
			if(!flip){
				if(keyManager.up){weap.get(weaponSelected).fire(x,y,3);tickA++;}
				else if(keyManager.down){weap.get(weaponSelected).fire(x,y,1);tickA++;}
				else if(keyManager.left){weap.get(weaponSelected).fire(x,y,2);tickA++;}
				else if(keyManager.right){weap.get(weaponSelected).fire(x,y,0);tickA++;}
			}
		}else{
			tickA++;
			if(tickA>weap.get(weaponSelected).fireRate){
				tickA=0;
			}
		}
		if(tickB>120){tickB=0;}else if(tickB!=0){tickB++;}
		tickB();
	}
	public void render(Graphics g){
		g.setFont(new Font("TimesRoman",Font.PLAIN,fontSize));
		g.drawString(""+life,0,fontSize);
		g.setColor(Color.green);
		if(tickB%30==0){
			g.fillRect(x,y,sx,sy);
		}else{
			g.drawRect(x,y,sx,sy);
		}
		weap.get(weaponSelected).render(g);
		g.setColor(Color.white);
		g.drawString(t,0,fontSize*2);
	}
	public void hit(){
		if(tickB==0){life--;tickB++;}}
}