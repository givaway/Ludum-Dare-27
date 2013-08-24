package org.HiarcGames.Testing.Content;



import java.util.ArrayList;
import java.util.Random;

import org.HiarcGames.Testing.Content.Components.*;
import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.EntityWorks.GameObject;
import org.HiarcGames.Testing.Helpers.Vector2;
import org.HiarcGames.Testing.StateMachine.State;

public class testState extends State{
	
	public testState()
	{
		super();
	}
	
	public void Start()
	{
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		GameObject g  = new GameObject("node",new Component[]{new Node(new Vector2(320,240))});
		g.type = "Node";
		g.SendMessage("SetMaster", "");
		GameObject[] newLevel = new GameObject[]{g};
		
		for(int i = 0; i< 10; i++)
		{
			GameObject[] newerLevel = new GameObject[]{};
			newerLevel = this.addLevel(newLevel,rand);
			newLevel = newerLevel;
		}
		
		
		
		
		
	}
	
	public GameObject[] addLevel(GameObject[] t, Random rand)
	{
		
		ArrayList<GameObject> newLevel = new ArrayList<GameObject>();
		
		for(GameObject a : t)
		{
			for(int i = 0; i < rand.nextInt(3)+2; i++)
			{
				GameObject g  = new GameObject("node",new Component[]{new Node(new Vector2(rand.nextInt(640),rand.nextInt(480)))});
				g.type = "Node";
				newLevel.add(g);
				a.SendMessage("AddChild", g);
			}
		}
		return newLevel.toArray(new GameObject[]{});
	}

}
