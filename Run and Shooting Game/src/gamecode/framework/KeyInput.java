package gamecode.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gamecode.objects.Bullet;

public class KeyInput extends KeyAdapter {

	gamecode.windows.Handler handler;
	public static int ok=1;
	public KeyInput(gamecode.windows.Handler handler2)
	{
		this.handler=handler2;
		
	}
	public KeyInput()
	{
		
	}
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		for(int i=0; i<handler.object.size();i++)
		{
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getId()==ObjectId.Player){
				
				if(key==KeyEvent.VK_D) tempObject.setVelX(5);
				if(key==KeyEvent.VK_A) tempObject.setVelX(-5);
				if(key==KeyEvent.VK_W && !tempObject.isJumping())
					{
					tempObject.setJumping(true);
					tempObject.setVelY(-20);
					
					}
				if(key==KeyEvent.VK_SPACE)
				{
					
					handler.addObject(new Bullet(tempObject.getX(),tempObject.getY()+48, handler, ObjectId.Bullet,0));				
					
					
				
				}
			}
			
			
		}
		if(key==KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
			
		}
		
	
	}
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		for(int i=0; i<handler.object.size();i++)
		{
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getId()==ObjectId.Player){
				
				if(key==KeyEvent.VK_D) tempObject.setVelX(0);
				if(key==KeyEvent.VK_A) tempObject.setVelX(0);
				
			}
		}
		
	}
}
