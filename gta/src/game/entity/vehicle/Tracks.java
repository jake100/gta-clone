package game.entity.vehicle;

import game.Game;
import game.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tracks extends Entity
{
	private float alpha = 1.0f, decrement = 0.0002f, minAlpha = 0.035f;
	private boolean alive = true;
	public Tracks(int x, int y, int rotation) throws SlickException
	{
		super(Controller.Null, x, y, 1.5f);
		img = new Image("res/track.png");
		
		img.setRotation((float)rotation);
	}
	public void update(GameContainer gc, int delta) throws SlickException
	{
		alpha -= decrement;
		if(alpha < minAlpha)alive = false;
		img.setAlpha(alpha);
	}
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		img.draw(Game.px - x, Game.py - y, scale);
	}
	public boolean isAlive() {return alive;}
	public boolean isDead() {return !alive;}
	
}
