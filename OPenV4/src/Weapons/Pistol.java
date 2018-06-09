package Weapons;
import Entities.Entities;
import Entities.Player;

public class Pistol extends Weapons{
	public Pistol(){
		//gS=Entities.gameState;
		fireRate=30;
		dam=(int)(Math.random()*(10*lv));
		name+="Pistol";
	}
}
