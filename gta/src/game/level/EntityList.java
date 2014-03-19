package game.level;

import game.entity.Entity;
import game.entity.vehicle.Tank;
import game.entity.vehicle.Tracks;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EntityList 
{
	private static Map map;
	private Entity playerEntity;
	private ArrayList<Entity> entitys;

	public EntityList(ArrayList<Entity> entitys, Entity playerEntity) throws SlickException, IOException
	{
		this.entitys = entitys;
		this.playerEntity = playerEntity;
		entitys.add(playerEntity);
		map = new Map(new Image("res/back.png"));
	}
	public void update(GameContainer gc, int delta) throws SlickException 
	{
		for(int i = 0;i < entitys.size();i++)
		{
			Entity entity = entitys.get(i);
			entity.update(gc, delta);

			if(entity.isDead())entitys.remove(i);
		}
	}
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		for(Entity entity : entitys)
		{
			if(entity instanceof Tank)
			{
				ArrayList<Tracks> tracks = ((Tank)entity).getTracks();
				for(Tracks track : tracks)
				{
					if(track.isOnScreen())
					{
						if(entity.controller == Entity.Controller.Player)track.render(gc, g);
						else track.render(gc, g);
					}
				}
			}
			if(entity.isOnScreen())
			{
				entity.render(gc, g);
			}
		}
	}
}
