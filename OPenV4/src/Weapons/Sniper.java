package Weapons;
import java.awt.Graphics;

public class Sniper extends Weapons{
	public Sniper(){
		fireRate=90;
		speed=(int)(Math.random()*1)+10;
		life=120;
		acc=(int)((Math.random()*20)+80);
		dam=(int)(Math.random()*(lv*20))+lv*2;
		pen=5;
		sz=20;
		name+="Sniper";
	}
}
