package game.entity;

import game.Game;
import game.interfaces.IShooter;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Turret extends Entity implements IShooter
{
	private Image gunimg;
	private boolean shooting = false;
	private int ammo, maxAmmo;
	public Turret(Controller controller, int x, int y) throws SlickException 
	{
		super(controller ,x, y, 1.0f);
		gunimg = new Image("res/gun.png");
		rotSpeed = 0.115f;
		maxAmmo = 55;
		ammo = maxAmmo;
		healthBar = new HealthBar(100);
	}

	public void ceaseFire() {shooting = false;}

	public boolean isShooting() {return shooting;}

	public void shoot(int delta) throws SlickException 
	{
		
	}

	public void update(GameContainer gc, int delta) throws SlickException 
	{
		targetPlayer();
		healthBar.healthUpdate((int)(Game.px - x - 32), (int)(Game.py - y - 20), 50);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		gunimg.draw(Game.px - x, Game.py - y, scale, Color.lightGray);
		healthBar.render(gc, g);
	}

	public void targetPlayer()
	{
		float xDistance = Game.px;
        float yDistance = Game.py;
        double angleToTurn = Math.toDegrees(Math.atan2(yDistance, xDistance));
        gunimg.setRotation((float)angleToTurn - 92);
	}

	public void stop(float time) {}

	public void ceaseFire(float time) {}

	@Override
	public void shoot(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}


}
