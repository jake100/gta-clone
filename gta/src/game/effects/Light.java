package game.effects;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Light 
{
	private Image spriteSheet;
	protected Color tint;
	protected float x, y, scaleOrig, scale, alpha;
    public Light(float x, float y, float scale, Color tint) throws SlickException 
    {
        this.x = x;
        this.y = y;
        this.scale = scaleOrig = scale;
        this.alpha = 1f;
        this.tint = tint;
        
        spriteSheet = new Image("res/lighting/lighting_sprites.png", false, Image.FILTER_NEAREST);
    }
    public void update(int delta)
    {
    	scale = scaleOrig + 1f + .5f*(float)Math.sin(delta);
    }
}
