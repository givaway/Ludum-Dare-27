package org.HiarcGames.Testing.Content.Components;

import java.util.ArrayList;

import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.EntityWorks.GameObject;
import org.HiarcGames.Testing.Helpers.Globals;
import org.HiarcGames.Testing.Helpers.Vector2;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Node extends Component {
	
	ArrayList<GameObject> children = new ArrayList<GameObject>();
	GameObject master;
	boolean newMessage,newMove = false;
	float messagetimer,movementtimer = 0;
	Vector2 newpos = new Vector2(0,0);
	public boolean isMaster = false;
	Vector2 setPos;
	float speed = 200;
	boolean count = false;
	public Node(Vector2 pos)
	{
		super();
		this.setPos = pos;
	}
	public void Start()
	{
		this.Transform.Position = this.setPos;
	}
	
	public void sendMessage(Vector2 m)
	{
		for(int i = 0; i < this.children.size(); i++)
		{
			this.children.get(i).SendMessage("NewPosition", m);
		}
	}
	
	public <T> void RecieveMessage(String m,T data)
	{
		
		if(m.compareTo("NewPosition") == 0)
		{
			//System.out.println(this.gameobject.name);
			this.newpos = (Vector2)data;
			this.newMessage = true;
		}
		if(m.compareTo("AddChild") == 0)
		{
			this.children.add((GameObject)data);
		}
		if(m.compareTo("SetMaster") == 0)
		{
			this.isMaster = true;
		}
	}
	
	public boolean isConnectedTo(String n)
	{
		boolean ret = false;
		for(int i = 0; i < this.children.size(); i++)
		{
			GameObject child = this.children.get(i);
			if(child.name.compareTo(n) == 0)
			{
				ret = true;
				break;
			}
		}
		return ret;
	}
	public void keyPressed(int key, char c) 
	{
		if(this.isMaster)
		{
			
		}
    }
	public void Update(float dt, Input input)
	{
		if(!this.isMaster)
		{
			if(this.newMessage)
			{
				this.messagetimer += 1000f*dt;
				if(this.messagetimer >= 300f)
				{
					this.messagetimer = 0;
					this.newMessage = false;
					this.sendMessage(this.newpos);
					this.newMove = true;
				}
			}
			
			if(this.newMove)
			{

				this.movementtimer+=1000f*dt;
				this.newpos.normalize();
				Vector2 a = this.newpos.multiply(this.speed* dt);
				a.print();
				this.Transform.Position = this.Transform.Position.add(a);
				if(this.movementtimer >= 1000)
				{
					System.out.println("dead");
					this.newMove = false;
					this.newMessage = false;
					this.movementtimer = 0;
				}
			}
		}
		else
		{
			Input i = Globals.SM.gc.getInput();
			if(i.isKeyPressed(Input.KEY_W))
			{
				this.sendMessage(new Vector2(0,-10));
			}
			if(i.isKeyPressed(Input.KEY_A))
			{
				this.sendMessage(new Vector2(-10,0));
			}
			if(i.isKeyPressed(Input.KEY_S))
			{
				this.sendMessage(new Vector2(0,10));
			}
			if(i.isKeyPressed(Input.KEY_D))
			{
				this.sendMessage(new Vector2(10,0));
			}
		}
	}
	
	public void Render(Graphics g)
	{
		if(this.isMaster)g.fillRect(this.Transform.Position.x-20, this.Transform.Position.y-20, 40, 40);
		else
		{
			if(this.movementtimer >= 50f)g.setColor(new Color(255,0,0,255));
			g.drawRect(this.Transform.Position.x-20, this.Transform.Position.y-20, 40, 40);
		}
		g.setColor(new Color(255,255,255,255));
		for(int i = 0; i<this.children.size(); i++)
		{
			GameObject gs = this.children.get(i);
			g.drawLine(this.Transform.Position.x, this.Transform.Position.y, gs.Transform.Position.x, gs.Transform.Position.y);
		}
	}
}
