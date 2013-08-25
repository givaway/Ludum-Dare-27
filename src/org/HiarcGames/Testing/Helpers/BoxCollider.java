package org.HiarcGames.Testing.Helpers;

import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.Helpers.Vector2;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class BoxCollider extends Component{
	BodyDef boddef = new BodyDef();
	public Body body;
	PolygonShape shape = new PolygonShape();
	FixtureDef fix = new FixtureDef();
	Image image;
	int cx,cy,width,height;
	Vector2 pos;
	boolean isStatic;
	public BoxCollider(Vector2 pos,int width,int height,int cx,int cy, boolean isStatic)
	{
		super();
		this.pos = pos;
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.isStatic = isStatic;
		
		
	}
	public void Start()
	{
		this.Transform.Position = pos;
		this.boddef.position = this.Transform.Position.toVec();
		if(!this.isStatic)this.boddef.type = BodyType.DYNAMIC;
		else this.boddef.type = BodyType.STATIC;
		this.shape.setAsBox(1,this.height);
		this.body = world.createBody(this.boddef);
		this.fix.density = 1;
		this.fix.shape = this.shape;
		this.body.createFixture(this.fix);
	}
	public void Render(Graphics g)
	{
		g.pushTransform();
		g.rotate(this.body.getPosition().x+this.cx,this.body.getPosition().y+this.cy, (float)Math.toDegrees(this.body.getAngle()));
		g.drawRect(this.body.getPosition().x, this.body.getPosition().y, this.width,2 );
		g.popTransform();
	}

	
	
}
