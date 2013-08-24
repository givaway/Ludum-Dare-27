package org.HiarcGames.Testing.StateMachine;

import java.util.ArrayList;

import org.HiarcGames.Testing.EntityWorks.*;
import org.newdawn.slick.Graphics;

public class State {
	public String name;
	ArrayList<GameObject> ObjectList = new ArrayList<GameObject>();
	public State()
	{
		this.name = this.getClass().getSimpleName();
	}
	
	public void Start()
	{
		
	}
	public int getID()
	{
		return this.ObjectList.size();
	}
	
	public void Update(float dt)
	{
		//System.out.println("Update");
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).Update(dt);
		}
	}
	
	public void Render(Graphics g)
	{
		g.drawString("GameObject Count: "+this.ObjectList.size(), 10, 30);
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).Render(g);
		}
	}
	
	
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).mouseMoved( oldx,  oldy,  newx,  newy);
		}
	}
	public void mousePressed(int button, int x, int y)
	{
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).mousePressed( button,  x,  y);
		}
	}
	public void mouseReleased(int button, int x, int y)
	{
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).mouseReleased( button,  x,  y);
		}
	}
	public void mouseWheelMoved(int change)
	{
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).mouseWheelMoved( change);
		}
	}
	
	public void keyPressed(int key, char c) 
	{
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).keyPressed( key,  c) ;
		}
    }
	public void keyReleased(int key, char c) 
	{
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			this.ObjectList.get(i).keyReleased( key,  c) ;
		}
    }
	public void AddObject(GameObject g)
	{
		this.ObjectList.add(g);
	}
	
	public GameObject[] getType(String t)
	{
		ArrayList<GameObject> ret = new ArrayList<GameObject>();
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			if(this.ObjectList.get(i).type.compareToIgnoreCase(t) == 0)
			{
				 ret.add(this.ObjectList.get(i));
			}
		}
		GameObject[] g = ret.toArray(new GameObject[]{});
		return g;
	}
	
	public GameObject[] FindGameObject(String n)
	{
		ArrayList<GameObject> ret = new ArrayList<GameObject>();
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			if(this.ObjectList.get(i).name.compareToIgnoreCase(n) == 0)
			{
				 ret.add(this.ObjectList.get(i));
			}
		}
		GameObject[] g = ret.toArray(new GameObject[]{});
		return g;
	}
	public String giveName(String n)
	{	
		int c = 0;
		while(this.FindGameObject((c==0?n:n+c)).length >= 1)
		{
			c++;
		}
		return c==0?n:n+c;
	}
	public void DestroyGameObject(String n)
	{
		for(int i = 0; i < this.ObjectList.size(); i++)
		{
			if(this.ObjectList.get(i).name.compareToIgnoreCase(n) == 0)
			{
				 this.ObjectList.remove(i);
			}
		}
	}
	
}
