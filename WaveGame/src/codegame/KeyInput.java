package codegame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler)
	{
		this.handler=handler;
	}
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
		}
			GameObject tempObject =handler.object.get(0);
			if(tempObject.getId()==ID.Player)
			{
				if(key==KeyEvent.VK_W)
				{
					tempObject.setVely(-5);
				}
				if(key==KeyEvent.VK_S)
				{
					tempObject.setVely(5);
				}
				if(key==KeyEvent.VK_A)
				{
					tempObject.setVelx(-5);
				}
				if(key==KeyEvent.VK_D)
				{
					tempObject.setVelx(5);
				}
			}
		
		
	}
		
		
	
public void keyReleased(KeyEvent e)
{
	GameObject tempObject =handler.object.get(0);
	int key=e.getKeyCode();
	
	if(key==KeyEvent.VK_W)
	{
		tempObject.setVely(0);
	}
	if(key==KeyEvent.VK_S)
	{
		tempObject.setVely(0);
	}
	if(key==KeyEvent.VK_A)
	{
		tempObject.setVelx(0);
	}
	if(key==KeyEvent.VK_D)
	{
		tempObject.setVelx(0);
	}
}
	
}
