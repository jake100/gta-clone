package game.level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Level 
{
	private Map map;
	private EntityList entityList;
	private boolean complete = false;
	public Level(Map map, EntityList entityList)
	{
		this.map = map;
		this.entityList = entityList;
	}
	public void update(GameContainer gc, int delta) throws SlickException
	{
		entityList.update(gc, delta);
	}
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		map.render(gc, g);
		entityList.render(gc, g);
	}
}
