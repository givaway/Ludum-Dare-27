package org.HiarcGames.Testing.Content.States.Game;

import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.EntityWorks.GameObject;
import org.HiarcGames.Testing.Helpers.BoxCollider;
import org.HiarcGames.Testing.Helpers.Vector2;
import org.HiarcGames.Testing.StateMachine.State;

public class Level1 extends State{

	public Level1()
	{
		
	}
	public void Start()
	{
		new GameObject("bc test",new Component[]{new BoxCollider(new Vector2(200,200),50,50,25,25,false)});
		new GameObject("bc test",new Component[]{new BoxCollider(new Vector2(255,210),50,50,25,25,false)});
		new GameObject("bc test",new Component[]{new BoxCollider(new Vector2(310,220),50,50,25,25,false)});
		new GameObject("bc test",new Component[]{new BoxCollider(new Vector2(365,230),50,50,25,25,false)});
		new GameObject("bc test",new Component[]{new BoxCollider(new Vector2(420,240),50,50,25,25,false)});
		new GameObject("bc test",new Component[]{new BoxCollider(new Vector2(200,500),400,50,25,25,true)});
	}
}
