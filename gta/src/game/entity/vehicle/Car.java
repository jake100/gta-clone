package game.entity.vehicle;

import game.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Car extends Vehicle
{
	SpriteSheet spriteSheet;
	private int counter = 0;
	
	//private float 
	public Car(Controller controller, int x, int y) throws SlickException 
	{
		super(controller, x, y, 1.0f);
		img = new Image("res/car.png");
		spriteSheet = new SpriteSheet(new Image("res/light.png", false, Image.FILTER_NEAREST), 16, 16);
	}

	public void update(GameContainer gc, int delta) throws SlickException
	{
		playerUpdate(gc, delta);
		if(controller != Controller.Player)
		{
			int switchTime = 1000;
			if(counter == 0)randDir();
			counter++;
			if(counter > switchTime)
			{
				counter = 0;
				randDir();
			}
		}
		move(delta);
	}
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		int lightXOffset = 3;
		int lightYOffset = 10;
		if(controller == controller.Player)
		{
			img.draw(Game.WIDTH / 2, Game.HEIGHT / 2, scale);
		}
		else
		{
			img.draw(Game.px - x, Game.py - y, scale);
		}
	}

}
