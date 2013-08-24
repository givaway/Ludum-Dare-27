package org.HiarcGames.Testing.Content.Components.Menu;



import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.Helpers.Globals;
import org.HiarcGames.Testing.Helpers.Vector2;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

public class SpotLight extends Component{
	Polygon poly;
	float angle = 0;
	public SpotLight()
	{
		super();
	}
	
	public void Start()
	{
		this.Transform.Position = new Vector2(Globals.Width+200,30);
		this.poly = new Polygon(new float[]{0,0,100,2000,-100,2000});
	}
	public void Update(float dt)
	{
		
		this.angle = this.Transform.Position.AngleBetween(new Vector2(input.getMouseX(),input.getMouseY()), 270);
		System.out.println(this.angle);
	}
	public void Render(Graphics g)
	{
		g.pushTransform();
		g.translate(this.Transform.Position.x, this.Transform.Position.y);
		g.rotate(this.Transform.Position.y, this.Transform.Position.y,this.angle);
		g.setColor(new Color(255,255,255,255));
		g.draw(this.poly);
		g.popTransform();
	}

}
