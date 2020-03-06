package gamecode.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import gamecode.framework.GameObject;
import gamecode.framework.KeyInput;
import gamecode.framework.ObjectId;
import gamecode.framework.Texture;
import gamecode.windows.Game;

public class Block extends GameObject {
	Texture tex=Game.getInstance();
	private gamecode.windows.Handler handler;
	private int type;
	public Block(float x, float y,int type, ObjectId id,gamecode.windows.Handler handler2) {
		super(x, y,id);
		this.type=type;
		this.handler=handler2;
	}
KeyInput in=new KeyInput();
	public void tick(LinkedList<GameObject> object) {
		
		
		
		//Collision(object);
		
	}
	 void Collision(LinkedList<GameObject> object) {
			
			for(int i=0;i<handler.object.size();i++)
			{
			
				GameObject tempObject=handler.object.get(i);
				
				if(tempObject.getId()==ObjectId.Bullet)
				{
					if(getBounds().intersects(tempObject.getBounds())){
						handler.removeObject(tempObject);
					
			}
			}
			}
		}
	
	
	
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.white);
		//g.drawRect((int)x,(int)y,32,32);
		if(type==0)
			g.drawImage(tex.block[0],(int)x,(int)y,null);
		if(type==1)
			g.drawImage(tex.block[1],(int)x,(int)y,null);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
		
	}
	

}
