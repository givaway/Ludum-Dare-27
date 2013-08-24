package org.HiarcGames.Testing.Helpers;

import org.HiarcGames.Testing.StateMachine.State;
import org.HiarcGames.Testing.StateMachine.StateMachine;

public interface Globals {
	StateMachine SM = new StateMachine();
	Timers TIMER = new Timers();
	int Width = 1280;
	int Height = 720;
	
	boolean vsync = false;
}
