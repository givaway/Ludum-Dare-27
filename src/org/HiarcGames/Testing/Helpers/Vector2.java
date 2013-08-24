package org.HiarcGames.Testing.Helpers;

import java.text.DecimalFormat;

public class Vector2 {
	public float x,y;
	private DecimalFormat form = new DecimalFormat("0.000000");
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	// ADD
	public Vector2 add(Vector2 a)
	{
		return new Vector2(this.x + a.x,this.y+a.y);
	}
	public Vector2 add(float x, float y)
	{
		return new Vector2(this.x + x,this.y+y);
	}
	public Vector2 add(float a)
	{
		return new Vector2(this.x + a,this.y+a);
	}
	
	//SUBTRACT
	public Vector2 subract(Vector2 a)
	{
		return new Vector2(this.x - a.x,this.y-a.y);
	}
	public Vector2 subtract(float x, float y)
	{
		return new Vector2(this.x - x,this.y-y);
	}
	public Vector2 subtract(float a)
	{
		return new Vector2(this.x - a,this.y - a);
	}
	
	//DIVIDE
	public Vector2 divide(Vector2 a)
	{
		return new Vector2(this.x / a.x,this.y/a.y);
	}
	public Vector2 divide(float x, float y)
	{
		return new Vector2(this.x / x,this.y/y);
	}
	public Vector2 divide(float a)
	{
		return new Vector2(this.x / a,this.y/a);
	}
	
	//MULTIPLY
	public Vector2 multiply(Vector2 a)
	{
		return new Vector2(this.x * a.x,this.y*a.y);
	}
	public Vector2 multiply(float x, float y)
	{
		return new Vector2(this.x * x,this.y*y);
	}
	public Vector2 multiply(float a)
	{
		return new Vector2(this.x * a,this.y*+a);
	}
	
	
	//SLOPE
	public Vector2 slope(Vector2 v2)
	{
		   float x = v2.x - this.x;
	       float y = v2.y - this.y;
	       return new Vector2(x,y);
	
	}
	public Vector2 slope()
	{
		return new Vector2(0,0);
	}
	public int distance(Vector2 v2)
	{
		double xDist = Math.abs(this.x - v2.x);  
	    double yDist = Math.abs(this.y - v2.y);  
	    double Distance = Math.sqrt((xDist * xDist) + (yDist * yDist));
	    return (int)Distance;
	    
	}
	
	//Compare Vectors
	public boolean equals(Vector2 v2)
	{
		if(this.x == v2.x && this.y == v2.y ) return true;
		else return false;
	}
	public void set(Vector2 v2)
	{
		this.x = v2.x;
		this.y = v2.y;
	}
	
	public double length()
	{
		return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
	}
	
	public Vector2 Normalized()
	{
		return new Vector2((float)(this.x/this.length()),(float)(this.x/this.length()));
	}
	
	public void normalize()
	{
		this.x = (float)(this.x/this.length());
		this.y = (float)(this.y/this.length());
		
	}
	
	public float dot(Vector2 v2)
	{
		return (this.x * v2.x )+(this.y*v2.y);
	}
	
	public float AngleBetween(Vector2 vec,float adds)
	{
		double angle = Math.toDegrees(Math.atan2(vec.y - this.y , vec.x - this.x));
		if(angle < 0){ angle +=360; }
		return (float)Math.abs(angle)+adds;
	}
	
	public float AngleBetweenRad(Vector2 vec,float adds)
	{
		double angle = Math.toDegrees(Math.atan2(vec.y - this.y , vec.x - this.x));
		if(angle < 0){ angle +=360; }
		return (float) (Math.toRadians(Math.abs(angle))+adds);
	}
	public void print()
	{
		System.out.println("("+this.x+","+this.y+")");
	
	}
	
}