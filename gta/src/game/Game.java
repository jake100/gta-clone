package game;

import game.state.MenuState;
import game.state.PlayState;
import game.state.SplashState;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.shader.ShaderProgram;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame 
{
	public static final int WIDTH = 1256, HEIGHT = 866;
	public static final int Splash = 0, MENU = 1, PLAY = 2;
	public static final String Title = "Tank Game";
	public static ShaderProgram program0;
	public static ShaderProgram program1;
	public static boolean shaderWorks = false;
	public static boolean reticleShader = false;
	public static float px, py, tx, ty;
	public Game() throws SlickException
	{
		super(Title);
		this.addState(new SplashState(Splash));
		this.addState(new MenuState(MENU));
		this.addState(new PlayState(PLAY));
	}
	public void initStatesList(GameContainer gc) throws SlickException 
	{
		initShaderProgram();
		getState(Splash).init(gc, this);
		getState(MENU).init(gc, this);
		getState(PLAY).init(gc, this);
		enterState(Splash);
	}
	public void initShaderProgram()
	{
		try 
		{
			final String VERT = "res/shaders/pass.vert";
			final String FRAG_0 = "res/shaders/bullet.frag";
			final String FRAG_1 = "res/shaders/reticle.frag";
			program0 = ShaderProgram.loadProgram(VERT, FRAG_0);
			program1 = ShaderProgram.loadProgram(VERT, FRAG_1);
			shaderWorks = true;
			reticleShader = true;
		} 
		catch (SlickException e) {System.out.println("error bitch");}
	}
	public static void main(String args[]) throws SlickException
	{
		 AppGameContainer app = new AppGameContainer(new Game());
		 app.setDisplayMode(WIDTH, HEIGHT, false);
		 app.start();
	}

}
