package game.entity;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Blast extends Entity
{
	public static enum Type{Default}
	protected Type type;
	protected Image[] anim;
	protected int animNum = 0, animMax;
	protected float radius, damage, rotation, duration;
	public Blast(Type type, float x, float y) throws SlickException
	{
		super(Controller.Null, (int)x, (int)y, 0.85f);
		this.type = type;
		if(type == Type.Default)
		{
			animMax = 3;
			anim = new Image[animMax];
			anim[0] = new Image("res/min_blast.png");
			anim[1] = new Image("res/blast.png");
			anim[2] = new Image("res/max_blast.png");
			rotation = new Random().nextInt(360);
			radius = 5.0f;
			damage = 2.0f;
			duration = 40.0f;
		}
		anim[animNum].setRotation(new Random().nextInt(360));
	}
	public void update(GameContainer gc, int delta) throws SlickException
	{
		duration -= 0.155f;
		if((int)duration % 10 == 0) animNum = 1;
		if((int)duration % 20 == 0) animNum = 2;
		if((int)duration % 30 == 0) animNum = 0;
		if((int)duration % 10 == 0) anim[animNum].setRotation(new Random().nextInt(360));
		if(duration <= 0) alive = false;
	}
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		anim[animNum].draw((int)x - anim[animNum].getWidth()/2, (int)y - anim[animNum].getHeight()/2, scale);
	}
	public void heal(float amount) 
	{
		
	}
	public void damage(float amount) {
		
	}
}
