package game.level;

import game.Game;
import game.MenuButton;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class NewLevelSelector 
{
	private MenuButton level0button, menu;
	private LevelHandler levelHandler = null;
	private int counter = 0 ,treshold = 150;
	public NewLevelSelector() throws SlickException
	{
		level0button = new MenuButton("  Level0", 50);
		menu = new MenuButton("   Menu", 150);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException, IOException
	{
		counter++;
		if(levelHandler == null && counter > treshold)
		{
			level0button.update(gc, sbg, delta);
			menu.update(gc, sbg, delta);
			if(level0button.isClicked()) 
			{
				levelHandler = new LevelHandler(0);
			}
			if(menu.isClicked()) 
			{
				sbg.getState(Game.MENU).init(gc, sbg);
				sbg.getState(Game.PLAY).init(gc, sbg);
				sbg.enterState(Game.MENU);
			}
		}
		else if(counter > treshold)levelHandler.update(gc, delta);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(levelHandler == null && counter > treshold)
		{
			level0button.render(gc, sbg, g);
			menu.render(gc, sbg, g);
		}
		else if(counter > treshold)levelHandler.render(gc, g);
	}
}
