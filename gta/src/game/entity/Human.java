package game.entity;

import game.Game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Human extends Entity
{
	private Animation sprite;
	private SpriteSheet sheet;
	public Human(Controller controller, int x, int y) throws SlickException 
	{
		super(controller, x, y, 1.0f);
		sheet = new SpriteSheet("res/human.png",31,46);
		speed = 1.5f;
	}

	public void update(GameContainer gc, int delta) throws SlickException 
	{
		if(controller == Controller.Player)playerUpdate(gc, delta);
		else randDir();
		if(left) x+= speed;
		if(right) x-= speed;
		if(forward) y+= speed;
		if(backward) y-= speed;
		clearDir();
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		if(controller == Controller.Player)
		{
			if(dir == Dir.Forward)sheet.getSprite(0, 0).draw(Game.WIDTH /2, Game.HEIGHT /2, scale);
			if(dir == Dir.Backward)sheet.getSprite(1, 0).draw(Game.WIDTH /2, Game.HEIGHT /2, scale);
			if(dir == Dir.Left)sheet.getSprite(1, 1).draw(Game.WIDTH /2, Game.HEIGHT /2, scale);
			if(dir == Dir.Right)sheet.getSprite(0, 1).draw(Game.WIDTH /2, Game.HEIGHT /2, scale);
		}
		else
		{
			if(dir == Dir.Forward)sheet.getSprite(0, 0).draw(Game.px - x, Game.py - y, scale);
			if(dir == Dir.Backward)sheet.getSprite(1, 0).draw(Game.px - x, Game.py - y, scale);
			if(dir == Dir.Left)sheet.getSprite(1, 1).draw(Game.px - x, Game.py - y, scale);
			if(dir == Dir.Right)sheet.getSprite(0, 1).draw(Game.px - x, Game.py - y, scale);
		}
	}

}
