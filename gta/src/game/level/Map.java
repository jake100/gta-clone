package game.level;

import game.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map 
{
	private TiledMap map;
	public Map(Image img) throws SlickException
	{
		map = new TiledMap("res/level_data/level0/level0.tmx");
	}
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		map.render((int)Game.px, (int)Game.py);
		
	}
	
}
