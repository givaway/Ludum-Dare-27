package org.HiarcGames.Testing.Helpers;

import org.HiarcGames.Testing.EntityWorks.GameObject;

public class Trans {
	
	public Vector2 Position = new Vector2(0,0);
	public int Z,rotOff = 0;
	public float Rot = 0;
	
	boolean ZIgnore = false;
	GameObject Follow,RotTowards = null;
	
	public Trans()
	{
		
	}
	
	public void Start()
	{
		
	}
	public void Update(int dt)
	{
		if(this.Follow != null)
		{
			this.Position.set(this.Follow.Transform.Position);
		}
		
		if(this.RotTowards != null)
		{
			this.Rot = this.Position.AngleBetweenRad(this.RotTowards.Transform.Position, this.rotOff);
		}
	}
	public void follow(GameObject f)
	{
		this.Follow = f;
	}
	public void rotateTowards(GameObject f)
	{
		this.RotTowards = f;
	}
	public void follow()
	{
		this.Follow = null;
	}
	public void rotateTowards()
	{
		this.RotTowards = null;
	}

}
