package game.level;

import game.entity.Entity;
import game.entity.Human;
import game.entity.Turret;
import game.entity.vehicle.Car;
import game.entity.vehicle.Tank;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LevelHandler 
{
	private Level curLevel, level0;
	private Map forestMap;
	private EntityList entityList;
	private ArrayList<Entity> entitys;
	private Tank tank;
	private int levelNum;
	public LevelHandler(int levelNum) throws SlickException, IOException
	{
		this.levelNum = levelNum;
		entitys = new ArrayList<Entity>();
		if(levelNum == 0)
		{
			tank = new Tank(Entity.Controller.Player, -500, -500);
			forestMap = new Map(new Image("res/back.png"));
			for(int i = 0;i < 40;i++)
			{
				entitys.add(new Turret(Entity.Controller.Null, i * -500, i * -500));
				entitys.add(new Tank(Entity.Controller.Enemy, i * -550, i * -550));
				entitys.add(new Car(Entity.Controller.Enemy, i * -600, i * -600));
				entitys.add(new Human(Entity.Controller.Enemy, i * -600, i * -600));
			}
			entityList = new EntityList(entitys, tank);
			level0 = new Level(forestMap, entityList);
			curLevel = level0;
		}
	}
	public void update(GameContainer gc, int delta) throws SlickException
	{
		curLevel.update(gc, delta);
	}
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		curLevel.render(gc, g);
	}
}
