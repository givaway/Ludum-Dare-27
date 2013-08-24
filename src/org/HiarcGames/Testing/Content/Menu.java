package org.HiarcGames.Testing.Content;

import org.HiarcGames.Testing.Content.Components.Menu.*;
import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.EntityWorks.GameObject;
import org.HiarcGames.Testing.StateMachine.State;

public class Menu extends State {

	public Menu()
	{
		super();
	}
	
	public void Start()
	{
		new GameObject("Menu BG",new Component[]{new MenuBG()});
		new GameObject("Menu Item",new Component[]{new MenuItem("Start",0)});
		new GameObject("Menu Item",new Component[]{new MenuItem("Options",1)});
		new GameObject("Menu Item",new Component[]{new MenuItem("Credits",2)});
		new GameObject("Menu Item",new Component[]{new SpotLight()});
	}
}
