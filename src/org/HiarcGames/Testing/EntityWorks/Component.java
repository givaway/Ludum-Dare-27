package org.HiarcGames.Testing.EntityWorks;

import org.HiarcGames.Testing.Helpers.Trans;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Component {
	public String name;
	public int id;
	public GameObject gameobject;
	public Trans Transform;
	public Input input;
	public Component()
	{
		this.name = this.getClass().getSimpleName();
	}
	
	public void Start()
	{
		
	}
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		
	}
	public void mousePressed(int button, int x, int y)
	{
		
	}
	public void mouseReleased(int button, int x, int y)
	{
		
	}
	public void mouseWheelMoved(int change)
	{
		
	}
	
	public void keyPressed(int key, char c) 
	{
		
    }
	public void keyReleased(int key, char c) 
	{
		
    }
	
	public void Update(float dt)
	{
	}
	
	public void Render(Graphics g)
	{
		
	}
	
	public <T> void RecieveMessage(String m, T data)
	{
		
	}
	protected void Destroy()
	{

		this.gameobject.Destroy();
	}
}
