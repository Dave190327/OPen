package Projectiles;

import java.awt.Color;
import java.awt.Graphics;

import Entities.Entities;

public class BasicBullet extends Projectile{
	public BasicBullet(int x,int y,int xs,int ys){
		init();
		int temp=20;
		this.xs=xs;
		this.ys=ys;
		this.x=x+temp;
		this.y=y+temp;
		sx-=temp*2;
		sy-=temp*2;
	}
	public BasicBullet(int x,int y,double xs,double ys,int d,int p,int l,int s){
		init();
		int temp=s;
		this.xs=xs;
		this.ys=ys;
		this.x=x+temp;
		this.y=y+temp;
		sx-=temp*2;
		sy-=temp*2;
		dam=d;
		pen=p;
		life=l;
		size=s;
	}
}