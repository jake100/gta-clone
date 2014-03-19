package game.state;

import game.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SplashState extends BasicGameState
{
	private Image back = null;
	private int counter = 0;
	public SplashState(int id)
	{
		
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		back = new Image("res/splash.png");
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{
		counter += delta;
		if(counter > 600)sbg.enterState(1);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		back.draw();
		g.drawString(Game.Title, 5 + counter, 5 + counter);
	}

	public int getID() {return 0;}

}
