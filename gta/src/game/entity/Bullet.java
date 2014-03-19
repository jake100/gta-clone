package game.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet extends Entity
{
	private boolean hit = false;
	public Bullet(int x, int y, float rot) throws SlickException 
	{
		super(Controller.Null, x, y, 1.0f);
		speed = 1.5f;
		img = new Image("res/bullet.png");
		width = img.getWidth() * scale;
		height = img.getHeight() * scale;
		img.setRotation(rot);
	}

	public void update(GameContainer gc, int delta) throws SlickException 
	{
		float hip = speed * delta;
		float rotation = img.getRotation();
		 
        x += hip * Math.sin(Math.toRadians(rotation));
        y -= hip * Math.cos(Math.toRadians(rotation));
	}

	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		img.draw(x, y, scale);
	}
	
}
