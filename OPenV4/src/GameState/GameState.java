package GameState;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Entities.Entities;
import Entities.Player;
import Entities.Spawner;
import Entities.Wall;
import Entities.Zombie;
import Items.Item;
import Misc.Handler;
import Projectiles.Projectile;

public class GameState{
	Handler handler;
	public Player player;
	public World world;
	int ec=0,tickA=0;
	public int fontSize=50;
	public static boolean debug=false;
	public ArrayList<Entities> obj=new ArrayList<Entities>();
	public ArrayList<Projectile> projectile=new ArrayList<Projectile>();
	public ArrayList<Item> items=new ArrayList<Item>();
	public ArrayList<Wall> wall=new ArrayList<Wall>();
	public GameState(Handler handler){
		this.handler=handler;
		Weapons.Weapons.gS=this;
		Entities.gameState=this;
		Projectile.gS=this;
		World.gS=this;
		world=new World();
		player=new Player();
	}
	public void tick(){
		//if(tickA==0){createZombie();}else if(tickA>60){tickA=-1;}tickA++;
		player.tick();
		int px=player.x;
		int py=player.y;
		int px2=player.x+player.sx;
		int py2=player.y+player.sy;
		for(int x=0;x<obj.size();x++){
			int ex=obj.get(x).x;
			int ey=obj.get(x).y;
			int ex2=obj.get(x).x+obj.get(x).sx;
			int ey2=obj.get(x).y+obj.get(x).sy;
			if(obj.get(x).melee & px2>ex & px<ex2 & py2>ey & py<ey2){
				player.hit();
			}
			obj.get(x).tick();
		}
		for(int x=0;x<projectile.size();x++){
			projectile.get(x).tick();
		}
		for(int x=0;x<items.size();x++){
			items.get(x).tick();
		}
	}
	public void render(Graphics g){
		for(int x=0;x<projectile.size();x++){
			projectile.get(x).render(g);
		}
		for(int x=0;x<items.size();x++){
			items.get(x).render(g);
		}
		player.render(g);
		for(int x=0;x<obj.size();x++){
			obj.get(x).render(g);
		}
		g.setColor(Color.BLACK);
		//g.drawString(""+obj.size(), 0, 200);
	}
	public void createWeaponDrop(){
		switch((int)(Math.random())){}
		items.get(items.size()-1).dropped=true;
		items.get(items.size()-1).x=player.x;
		items.get(items.size()-1).y=player.y;
		items.get(items.size()-1).id=items.size()-1;
	}
	public void createZombie(){obj.add(new Zombie());}
	public void createZombie(int x,int y){obj.add(new Zombie(x,y));}
	public void createSpawner(){obj.add(new Spawner());}
	public void createSpawner(int x,int y){obj.add(new Spawner(x,y));}
}
