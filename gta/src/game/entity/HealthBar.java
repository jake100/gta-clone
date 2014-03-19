package game.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class HealthBar 
{
	private int x, y, curHealth, maxHealth, width, height;
	public HealthBar(int maxHealth) throws SlickException
	{
		this.maxHealth = maxHealth;
	}
	public void healthUpdate(int x, int y, int curHealth)
	{
		this.x = x;
		this.y = y;
		this.curHealth = curHealth;
		width = 100;
		height = 10;
	}
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawRect(x, y, width, height);
		for(int i = 0;i < curHealth / 10;i++)
		{
			g.fillRect(x + i * height, y, height, height);
		}
	}
}
