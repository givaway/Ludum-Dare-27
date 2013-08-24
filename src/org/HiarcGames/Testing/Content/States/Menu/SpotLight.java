package org.HiarcGames.Testing.Content.States.Menu;



import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.Helpers.Globals;
import org.HiarcGames.Testing.Helpers.Vector2;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.util.MaskUtil;

public class SpotLight extends Component{
	Polygon poly;
	float angle = 0;
	MaskUtil m = new MaskUtil();
	Image wall;
	public SpotLight()
	{
		super();
	}
	
	public void Start()
	{
		this.Transform.Z = 1;
		this.Transform.Position = new Vector2(Globals.Width+500,30);
		this.poly = new Polygon(new float[]{0,0,100,2000,-100,2000});
		try {
			this.wall = new Image("Art/Menu/cavern.png");
			this.wall.setFilter(Image.FILTER_NEAREST);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void Update(float dt)
	{
		
		this.angle = this.Transform.Position.AngleBetween(new Vector2(input.getMouseX(),input.getMouseY()), 270);
	}
	public void Render(Graphics g)
	{
		
		g.pushTransform();
		
		g.translate(this.Transform.Position.x, this.Transform.Position.y);
		g.rotate(this.Transform.Position.y, this.Transform.Position.y,this.angle);
		g.setColor(new Color(255,255,0,60));
		m.defineMask();
		g.fill(this.poly);
		m.finishDefineMask();
		g.fill(this.poly);
		g.popTransform();
		m.drawOnMask();
		this.wall.draw(0, 0,(float)Globals.Height/(float)this.wall.getHeight() );
		m.resetMask();
		
	}

}
