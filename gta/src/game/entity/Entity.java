package game.entity;

import game.Game;
import game.interfaces.ILiving;

import java.awt.Rectangle;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public abstract class Entity implements ILiving
{
	public static enum Dir{Left, Right, Forward, Backward}
	public static enum Controller{Player, Enemy, Null}
	public Controller controller = Controller.Null;
	public Dir dir = Dir.Forward;
	protected Image img = null;
	protected float rotation, rotSpeed, speed, acceleration, deceleration, turnDeceleration, brakeSpeed, minSpeed, maxSpeed;
	protected float x, y , tx, ty, scale, width, height;
	protected float curHealth, maxHealth;
	protected boolean alive = true, left = false, right = false, forward = false, backward = false;
	protected HealthBar healthBar;
	public Entity(Controller controller, int x, int y, float scale)
	{
		this.controller = controller;
		this.x = x;
		this.y = y;
		this.scale = scale;
		curHealth = 100;
		maxHealth = 100;
		speed = 1.5f;
	}
	public void playerUpdate(GameContainer gc, int delta)
	{
		if(controller == Controller.Player)
		{
			Input input = gc.getInput();
			if(input.isKeyDown(Input.KEY_A))
			{
				left = true;
				dir = Dir.Left;
			}
			else left = false;
			if(input.isKeyDown(Input.KEY_D))
			{
				right = true;
				dir = Dir.Right;
			}
		    else right = false;
		 
		    if(input.isKeyDown(Input.KEY_W))
		    {
		    	forward = true;
		    	dir = Dir.Backward;
		    }
		    else forward = false;
		    if(input.isKeyDown(Input.KEY_S))
		    {
		    	backward = true;
		    	dir = Dir.Forward;
		    }
		    else backward = false;
		    Game.px = (int) x;
		    Game.py = (int) y;
		    
		}
	}
	public void randDir()
	{
		Random rnd = new Random();
		clearDir();
		int turnChance = 15;
		int moveChance = 5;
		if(rnd.nextInt(turnChance) == 0)left = true;
		if(rnd.nextInt(turnChance) == 0)right = true;
		if(rnd.nextInt(moveChance) == 0)forward = true;
		if(rnd.nextInt(moveChance) == 0)backward = true;
	}
	public void clearDir()
	{
		left = false;
		right = false;
		forward = false;
		backward = false;
	}
	public boolean isOnScreen()
	{
		int pad = 60;
		if(new Rectangle(-pad, -pad, Game.WIDTH + pad * 2, Game.HEIGHT + pad * 2).contains(getScreenBounds()) || controller == Entity.Controller.Player)return true;
		return false;
		
	}
	public void kill(){alive = false;}
	public void heal(float amount){curHealth += amount; if(curHealth > maxHealth)curHealth = maxHealth;}
	public void damage(float amount){curHealth -= amount; if(curHealth <= 0)alive = false;}
	public void setPos(int x, int y){this.x = x; this.y = y;}
	public void increaseX(float dx){x += dx;}
	public void setX(float x) {this.x = x;}
	public void setY(float y) {this.y = y;}
	public void decreaseX(float dx){x -= dx;}
	public void increaseY(float dy){y += dy;}
	public void decreaseY(float dy){y -= dy;}
	public Rectangle getScreenBounds(){return new Rectangle((int)(Game.px - x), (int)(Game.py - y), getWidth(), getHeight());}
	public Image getImg() {return img;}
	public boolean isAlive() {return alive;}
	public boolean isDead() {return !alive;}
	public boolean isForward() {return forward;}
	public boolean isBackward() {return backward;}
	public float gettx(){return tx;}
	public float getty(){return ty;}
	public float getX() {return x;}
	public float getY() {return y;}
	public void setImg(Image img) {this.img = img;}
	public int getMX(GameContainer gc){return gc.getInput().getMouseX();}
	public int getMY(GameContainer gc){return gc.getInput().getMouseY();}
	public int getWidth()
	{
		if(img != null)return (int) (img.getWidth() * scale);
		else return 0;
	}
	public int getHeight()
	{
		if(img != null)return (int) (img.getHeight() * scale);
		else return 0;
	}
	public abstract void update(GameContainer gc, int delta) throws SlickException;
	public abstract void render(GameContainer gc, Graphics g) throws SlickException;
}
