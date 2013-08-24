package org.HiarcGames.Testing.StateMachine;

import java.util.ArrayList;

import org.HiarcGames.Testing.Helpers.Globals;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class StateMachine {
	public State currentState;
	public GameContainer gc;
	ArrayList<State> States = new ArrayList<State>(); 
	public StateMachine()
	{
		
	}
	
	public void Update(float dt)
	{
		
		if(this.currentState != null)
		{
			this.currentState.Update(dt);
		}
	}
	
	public void Render(Graphics g)
	{
		if(this.currentState != null)
		{
			this.currentState.Render(g);
		}
	}
	
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		if(this.currentState != null)
		{
			this.currentState.mouseMoved( oldx,  oldy,  newx,  newy);
		}
	}
	public void mousePressed(int button, int x, int y)
	{
		if(this.currentState != null)
		{
			this.currentState.mousePressed( button,  x,  y);
		}
	}
	public void mouseReleased(int button, int x, int y)
	{
		if(this.currentState != null)
		{
			this.currentState.mouseReleased( button,  x,  y);
		}
	}
	public void mouseWheelMoved(int change)
	{
		if(this.currentState != null)
		{
			this.currentState.mouseWheelMoved( change);
		}
	}
	
	public void keyPressed(int key, char c) 
	{
		if(this.currentState != null)
		{
			this.currentState.keyPressed( key,  c);
		}
    }
	public void keyReleased(int key, char c) 
	{
		if(this.currentState != null)
		{
			this.currentState.keyReleased( key,  c);
		}
    }
	
	public void addState(State s)
	{
		this.States.add(s);
	}
	public void setState(State s)
	{
		this.currentState = s;
		
	}
	public void setState(String s)
	{
		for(int i = 0; i<this.States.size(); i++)
		{
			if(this.States.get(i).name.compareToIgnoreCase(s) == 0)
			{
				this.currentState = this.States.get(i);
				this.currentState.Start();
				break;
			}
		}
		
	}
}
