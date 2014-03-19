package game.entity.vehicle;

import game.entity.Entity;

import org.newdawn.slick.Image;

public abstract class Vehicle extends Entity
{
	public Vehicle(Controller controller, int x, int y, float scale)
	{
		super(controller, x, y, scale);
		rotSpeed = 0.0575f;
		maxSpeed = 3.0f;
		speed = 0;
		acceleration = 0.00075f;
		deceleration = 0.0025f;
		turnDeceleration = 0.00075f;
		brakeSpeed = 0.00125f;
	}
	public void move(int delta)
	{
		float hip = speed;
		rotation = img.getRotation();
		 
        x += hip * Math.sin(Math.toRadians(rotation));
        y -= hip * Math.cos(Math.toRadians(rotation));
        if(left)img = turn(img, -rotSpeed, delta);
        if(right)img = turn(img, rotSpeed, delta);
        if(forward)
        {
        	accelerate(-delta, acceleration);
        	if(speed > 0) speed -= brakeSpeed * delta;
        }
        if(backward)
        {
        	accelerate(delta, acceleration);
        	if(speed < 0) speed += brakeSpeed * delta;
        }
        if(!forward && !backward)
        {
        	decelerate(delta, deceleration);
        }
	}
	public Image turn(Image img, float speed, int delta)
	{
		img.rotate(speed * delta);
		decelerate(delta, turnDeceleration);
		return img;
	}
	public void accelerate(int delta, float acceleration)
	{
		speed += acceleration * delta;
		if(speed > maxSpeed)speed = maxSpeed;
		if(speed < -maxSpeed)speed = -maxSpeed;
	}

	public void decelerate(int delta, float deceleration)
	{
		if(speed > minSpeed) speed -= deceleration * delta;
		if(speed < minSpeed) speed += deceleration * delta;
	}

}
