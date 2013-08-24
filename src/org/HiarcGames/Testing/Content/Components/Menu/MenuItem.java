package org.HiarcGames.Testing.Content.Components.Menu;

import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.Helpers.Globals;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class MenuItem extends Component{
	int Width, Height,index = 0;
	String text = "";
	Font f;
	public MenuItem(String text, int index)
	{
		super();
		
		this.text = text;
		this.index = index;
	}
	public void Start()
	{
		this.Transform.Position.x = Globals.Width/2;
		this.Transform.Position.y = Globals.Height/2;
		
		this.Transform.Position.y += this.index * 30;
	}
	
	public void Update(float dt)
	{
		
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
