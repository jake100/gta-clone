package game.entity.vehicle;

import game.interfaces.IShooter;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class ShooterVehicle extends Vehicle implements IShooter
{
	protected float rotation;
	protected Image gun = null;
	protected int ammo, maxAmmo;
	protected boolean shooting = false;
	public ShooterVehicle(Controller controller, int x, int y, float scale) 
	{
		super(controller, x, y, scale);
		maxAmmo = 55;
		ammo = maxAmmo;
	}
	public void shoot(GameContainer gc, int delta) throws SlickException
	{
		tx = getMX(gc);
    	ty = getMY(gc);
		if(ammo > 0)
		{
			ammo--;
			shooting = true;
		}
	}
	public void ceaseFire() {shooting = false;}

	public boolean isShooting(){return shooting;}

	public void ceaseFire(float time) {}
}
