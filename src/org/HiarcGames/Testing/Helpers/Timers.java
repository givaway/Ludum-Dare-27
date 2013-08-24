package org.HiarcGames.Testing.Helpers;

import java.util.ArrayList;

public class Timers {
	ArrayList<timerTime> t = new ArrayList<timerTime> ();
	public Timers()
	{
	}
	public boolean getTimer(String name,int limit)
	{
		boolean ret = false;
		boolean found  = false;
		for(int i = 0; i < this.t.size(); i++)
		{
			timerTime ti = this.t.get(i);
			if(this.t.get(i).name.compareTo(name) == 0)
			{
				found = true;
				if(ti.time <= ti.limit)
				{
					ret = true;
					ti.time = 0f;
				}
			}
		}
		if(!found)
		{
			t.add(new timerTime(name,limit));
		}
		return ret;
	}
	public void Update(float dt)
	{
		for(int i = 0; i < this.t.size(); i++)
		{
			timerTime ti = this.t.get(i);
			ti.time+= 1000f*dt;

		}
	}
	
	
}
