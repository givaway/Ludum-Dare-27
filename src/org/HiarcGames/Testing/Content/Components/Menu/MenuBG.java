package org.HiarcGames.Testing.Content.Components.Menu;

import org.HiarcGames.Testing.EntityWorks.Component;
import org.HiarcGames.Testing.Helpers.Globals;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MenuBG extends Component{
	Image cavern, logo;
	public MenuBG()
	{
		super();
		
	}
	
	public void Start()
	{
		try {
			this.cavern = new Image("Art/Menu/MenuArt.png");
			this.cavern.setFilter(Image.FILTER_NEAREST);
			this.logo = new Image("Art/Menu/Title.png");
			this.logo.setFilter(Image.FILTER_NEAREST);

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Render(Graphics g)
	{
		
		this.logo.draw((Globals.Width/2)-(this.logo.getWidth()/2)*4, 100, 4);
	}

}
