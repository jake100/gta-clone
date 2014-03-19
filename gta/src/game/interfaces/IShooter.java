package game.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public interface IShooter 
{
	public void ceaseFire();
	public void ceaseFire(float time);
	public boolean isShooting();
	public void shoot(GameContainer gc, int delta) throws SlickException;
}
