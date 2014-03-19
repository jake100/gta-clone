package game.entity.vehicle;

import game.Game;
import game.interfaces.IShooter;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tank extends ShooterVehicle implements IShooter
{
	private int counter = 0, trackCounter = 0;
	private ArrayList<Tracks> tracks = new ArrayList<Tracks>();
	public Tank(Controller controller, int x, int y) throws SlickException, IOException
	{
		super(controller ,x, y, 1.25f);
		img = new Image("res/tank.png");
		gun = new Image("res/gun.png");
	}

	public void update(GameContainer gc, int delta) throws SlickException
	{
		if(controller == Controller.Player)
		{
	        double angleToTurn = Math.toDegrees(Math.atan2(getMY(gc) - Game.HEIGHT / 2, getMX(gc) - Game.WIDTH / 2));
	        gun.setRotation((float)angleToTurn - 92);
	       
	        if(gc.getInput().isMousePressed(0))
	        {
	        	shoot(gc, delta);
	        }
	        playerUpdate(gc, delta);
		}
		else
		{
			int switchTime = 1000;
			if(counter == 0)randDir();
			counter++;
			if(counter > switchTime)
			{
				counter = 0;
				shoot(gc, delta);
				randDir();
			}
		}
		move(delta);
		
	}
	public void trackUpdate(GameContainer gc, int delta) throws SlickException
	{
		float trackSpeed = (float) (maxSpeed / 12);
		trackCounter++;
		if((speed > trackSpeed || speed < -trackSpeed) && trackCounter % 15 == 0)
		{
			int xOffset = 1;
			int yOffset = 25;
			if(controller == Controller.Player) tracks.add(new Tracks((int)(x - Game.WIDTH / 2 - xOffset), (int)(y - Game.HEIGHT / 2 - yOffset), (int)img.getRotation()));
			else tracks.add(new Tracks((int)(x - xOffset), (int)(y - yOffset), (int)img.getRotation()));
		}
		for(int i = 0;i < tracks.size();i++)
		{
			Tracks track = tracks.get(i);
			track.update(gc, delta);
			if(track.isDead())tracks.remove(i);
		}
	}
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		if(controller == controller.Player)
		{
			img.draw(Game.WIDTH / 2, Game.HEIGHT / 2, scale);
			gun.draw(Game.WIDTH / 2 - 3, Game.HEIGHT / 2 - 3, scale * 1.15f);
		}
		else
		{
			img.draw(Game.px - x, Game.py - y, scale);
			gun.draw(Game.px - x - 3, Game.py - y - 3, scale * 1.15f);
		}
	}



	public ArrayList<Tracks> getTracks() {return tracks;}

	public void setTracks(ArrayList<Tracks> tracks) {this.tracks = tracks;}


}
