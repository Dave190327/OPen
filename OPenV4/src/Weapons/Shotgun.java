package Weapons;

public class Shotgun extends Weapons{
	int scatter,bs;
	public Shotgun(){
		clipSize=8;
		clip=clipSize;
		shotgun=true;
		fireRate=30;
		bs=(int)(Math.random()*1)+10;
		life=45-bs;
		acc=(int)((Math.random()*50)+40);
		scatter=(int)(Math.random()*20)+10;
		dam=(int)(Math.random()*(100-bs))+lv;
		dam/=scatter;
		if(dam<1)
			dam=1;
		sz=20;
		name+="Shotgun";
	}
	public void fire(int x,int y,int d){
		for(int z=0;z<scatter;z++){
			speed=bs-(Math.random()*2);
			fire2(x,y,d);
		}
		if(clip>0)
			clip--;
	}
}
