package org.HiarcGames.Testing.Content.States.Game.Components;

import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.Helpers.Vector2;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Block extends Component{
	BodyDef boddef = new BodyDef();
	Body block;
	PolygonShape shape = new PolygonShape();
	FixtureDef fix;
	Image image;
	public Block(Vector2 pos,int width,int height,int cx,int cy,Image i)
	{
		super();
		this.image = i;
		this.Transform.Position = pos;
		this.boddef.position = this.Transform.Position.toVec();
		this.boddef.type = BodyType.DYNAMIC;
		this.shape.setAsBox(width,height,this.Transform.Position.add(new Vector2(cx,cy)).toVec(),0);
		this.block = world.createBody(this.boddef);
		this.fix.density = 1;
		this.fix.shape = this.shape;
		block.createFixture(this.fix);
		
		
	}
	public void Start()
	{
		
	}
	public void Render(Graphics g)
	{
		
	}

	
	
}
