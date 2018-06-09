package GameState;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class World {
	public static GameState gS;
	public World(){
		String path="res/World/TestLevel";
		try{
			loadWorldLayerOne(path);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	public void loadWorldLayerOne(String p)throws FileNotFoundException{
		File file=new File(p);
		Scanner f=new Scanner(file);
		while(f.hasNextLine()){
			String temp=f.nextLine();
			if(temp.substring(0,8).equals("g.zombie")){
				String t=temp.substring(temp.indexOf("("),temp.indexOf(")"));
				gS.createZombie(
						Integer.parseInt(temp.substring(0,temp.indexOf(","))),
						10);
			}
			if(temp.substring(0,9).equals("g.spawner")){
				gS.createSpawner();
			}
			//System.out.println(temp.substring(0,8));
		}
		f.close();
	}
	public void tick(){}
}
