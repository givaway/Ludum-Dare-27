package org.HiarcGames.Testing.EntityWorks;

import java.util.ArrayList;

import org.HiarcGames.Testing.Helpers.Globals;
import org.HiarcGames.Testing.Helpers.Trans;
import org.HiarcGames.Testing.StateMachine.State;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GameObject {
	public String name;
	public int id;
	public String type = null;
	public Trans Transform = new Trans();
	public State Parent = null;
	ArrayList<Component> comps = new ArrayList<Component>();
	public GameObject(String name,Component[] comps)
	{
		this.Parent = Globals.SM.currentState;
		this.name = this.Parent.giveName(name);
		//System.out.println(this.name+": Created");
		for(int i = 0; i<comps.length; i++)
		{
			comps[i].gameobject = this;
			
			this.comps.add(comps[i]);
		}
		
		this.Parent.AddObject(this);
		this.Start();
	}
	
	public void Start()
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			Component c = this.comps.get(i);
			c.input = Globals.SM.gc.getInput();
			c.Transform = this.Transform;
			c.id = i;
			c.Start();
		}
	}
	
	
	public void Update(float dt)
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			Component c = this.comps.get(i);
			c.Transform = this.Transform;
			c.Update(dt);
			this.Transform = c.Transform;
		}
	}
	
	public void Render(Graphics g)
	{
		
		for(int i = 0; i < this.comps.size(); i++)
		{
			g.setColor(new Color(255,255,255,255));
			this.comps.get(i).Render(g);
		}
	}
	
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			this.comps.get(i).mouseMoved( oldx,  oldy,  newx,  newy);
		}
	}
	public void mousePressed(int button, int x, int y)
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			this.comps.get(i).mousePressed( button,  x,  y);
		}
	}
	public void mouseReleased(int button, int x, int y)
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			this.comps.get(i).mouseReleased( button,  x,  y);
		}
	}
	public void mouseWheelMoved(int change)
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			this.comps.get(i).mouseWheelMoved( change);
		}
	}
	
	public void keyPressed(int key, char c) 
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			this.comps.get(i).keyPressed( key,  c) ;
		}
    }
	public void keyReleased(int key, char c) 
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			this.comps.get(i).keyReleased( key,  c) ;
		}
    }
	
	public <T> void SendMessage(String m, T data )
	{
		for(int i = 0; i < this.comps.size(); i++)
		{
			this.comps.get(i).RecieveMessage(m, data);
		}
	}
	public Component[] getComponent(String n)
	{
		ArrayList<Component> ret = new ArrayList<Component>();
		for(int i = 0; i<this.comps.size(); i++)
		{
			if(this.comps.get(i).name.compareToIgnoreCase(n) == 0)
			{
				ret.add(this.comps.get(i));
			}
		}
		
		return ret.toArray(new Component[]{});
	}
	public void Destroy()
	{
		this.Parent.DestroyGameObject(this.name);
	
	}
}
