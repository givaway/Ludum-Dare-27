package org.HiarcGames.Testing.Content.States.Menu;

import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.Helpers.Globals;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class MenuItem extends Component{
	int Width, Height,index = 0;
	String text,opens = "";
	Font f;
	public MenuItem(String text, int index,String state)
	{
		super();
		
		this.text = text;
		this.index = index;
		this.opens = state;
	}
	public void Start()
	{
		this.Transform.Position.x = Globals.Width/2;
		this.Transform.Position.y = Globals.Height/2;
		
		this.Transform.Position.y += this.index * 30;
		this.Transform.Z = 2;
	}
	
	public void Update(float dt)
	{
		
	}
	
	public void mousePressed(int button, int x, int y)
	{
		if(button == Input.MOUSE_LEFT_BUTTON && this.isInside())
		{
			Globals.SM.setState(this.opens);
		}
	}
	
	public boolean isInside()
	{
		int x = input.getMouseX();
		int y = input.getMouseY();
		if(x > this.Transform.Position.x - this.Width && x < this.Transform.Position.x+this.Width && y > this.Transform.Position.y - this.Height && y< this.Transform.Position.y +this.Height)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Render(Graphics g)
	{
		if(this.f == null)
		{
			this.f = g.getFont();	
			this.Width = this.f.getWidth(this.text)/2;
			this.Height = this.f.getHeight(this.text)/2;
		}
		if(!this.isInside())
		{
			g.drawString(this.text, this.Transform.Position.x-this.Width, this.Transform.Position.y-this.Height);
			//g.drawRect(this.Transform.Position.x-this.Width, this.Transform.Position.y-this.Height, this.Width*2, this.Height*2);
		}
	}
}
