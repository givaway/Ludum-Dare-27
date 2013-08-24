package org.HiarcGames.Testing.EntityWorks;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class Layer {
	public float layer;
	ArrayList<GameObject> g = new ArrayList<GameObject>();
	public Layer(float layerNumber)
	{
		this.layer = layerNumber;
	}
	
	public void AddGameObject(GameObject g)
	{
		this.g.add(g);
	}
	
	public void Render(Graphics g)
	{
		for(GameObject a: this.g)
		{
			a.Render(g);
		}
	}
	
	
}
