package game;

import game.entity.vehicle.Tank;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hud 
{
	Image background = null;
	public Hud() throws SlickException
	{
		background = new Image("res/hud.png");
	}
	public void playerUpdate(Tank tank, int delta) throws SlickException
	{
		
	}
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		background.draw(0, 0, 1.0f);
	}
}
