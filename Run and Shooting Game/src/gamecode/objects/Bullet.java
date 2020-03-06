package gamecode.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;

import gamecode.framework.GameObject;
import gamecode.framework.ObjectId;

public class Bullet extends GameObject {

	private gamecode.windows.Handler handler;
	LinkedList<Bullet> shot = new LinkedList<Bullet>();
	public Bullet(float x, float y,gamecode.windows.Handler handler2, ObjectId id,int velX) {
		super(x, y,id);
		this.velX=velX;
		this.handler=handler2;
		// TODO Auto-generated constructor stub
	}
	public void Bullet(){}

	public void tick(LinkedList<GameObject> object) {
		
		x=x+8;
		Collision(object);
		//System.out.println(handler.object.size());
	}
	
	
	 void Collision(LinkedList<GameObject> object) {
		
		for(int i=0;i<handler.object.size();i++)
		{
		
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getId()==ObjectId.Block)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					for(int j=0;i<handler.object.size();i++)
					{
					GameObject ttempObject=handler.object.get(i);
					if(ttempObject.getId()==ObjectId.Bullet)
					{
						if(getBounds().intersects(ttempObject.getBounds())){
							handler.removeObject(ttempObject);
							
						
				}
				}
					}
		}
		}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y, 16, 16);

		
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,16,16);
	}
	
	

}
