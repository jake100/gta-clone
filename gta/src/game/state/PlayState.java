package game.state;

import game.Game;
import game.level.NewLevelSelector;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayState extends BasicGameState
{
	private static NewLevelSelector newLevelSelector;
	private boolean clip = false;
	public PlayState(int id)
	{
		
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		newLevelSelector = new NewLevelSelector();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		try {newLevelSelector.update(gc, sbg, delta);} 
		catch (IOException e) {}
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		newLevelSelector.render(gc, sbg, g);
		if(!clip)
		{
			g.setClip(0, 0, Game.WIDTH, Game.HEIGHT);
			clip = true;
		}
	}
	public int getID() {return 2;}
}
