package game.interfaces;

public interface ILiving
{
	public void kill();
	public void heal(float amount);
	public void damage(float amount);
	public boolean isAlive();
	public boolean isDead();
}
