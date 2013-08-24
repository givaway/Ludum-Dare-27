package org.HiarcGames.Testing;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.HiarcGames.Testing.Content.*;
import org.HiarcGames.Testing.Helpers.Globals;
import org.HiarcGames.Testing.StateMachine.StateMachine;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Game extends BasicGame
{

	public Game(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		Globals.SM.gc = gc;
		Globals.SM.addState(new Menu());
		Globals.SM.setState("Menu");
		

	}
	DecimalFormat form = new DecimalFormat("0.000000");
	@Override
	public void update(GameContainer gc, int i) throws SlickException
	{
		double delta = i*0.001;
		
		Globals.TIMER.Update(Float.parseFloat(form.format(delta)));
		Globals.SM.Update(Float.parseFloat(form.format(delta)));
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		Globals.SM.Render(g);
	}
	
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		Globals.SM.mouseMoved( oldx,  oldy,  newx,  newy);
	}
	public void mousePressed(int button, int x, int y)
	{
		Globals.SM.mousePressed( button,  x,  y);
	}
	public void mouseReleased(int button, int x, int y)
	{
		Globals.SM.mouseReleased( button,  x,  y);
	}
	public void mouseWheelMoved(int change)
	{
		Globals.SM.mouseWheelMoved( change);
	}
	
	public void keyPressed(int key, char c) 
	{
		Globals.SM.keyPressed( key,  c) ;
    }
	public void keyReleased(int key, char c) 
	{
		Globals.SM.keyReleased( key,  c) ;
    }

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("Bright Cavern"));
			appgc.setDisplayMode(Globals.Width,Globals.Height, false);
			appgc.setShowFPS(true);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
