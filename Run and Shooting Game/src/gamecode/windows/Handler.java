package gamecode.windows;

import java.awt.Graphics;
import java.util.LinkedList;

import gamecode.framework.GameObject;
import gamecode.framework.ObjectId;
import gamecode.objects.Block;

public class Handler {

	public LinkedList<GameObject> object=new LinkedList<GameObject>();
	private GameObject tempObject;
	
	public void tick()
	{
		for(int i=0;i<object.size();i++)
		{
			tempObject=object.get(i);
			tempObject.tick(object);
		}
		
	}
	public void render(Graphics g)
	{
		for(int i=0;i<object.size();i++)
		{
			tempObject=object.get(i);
			tempObject.render(g);
		}
		
	}
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	/*
	 public void createLevel()
	{
		for(int xx=0; xx<Game.WIDTH+32;xx+=32)
		{
			
			addObject(new Block(xx,Game.HEIGHT-32,ObjectId.Block));
	
		}
		
		for(int yy=0;yy<Game.HEIGHT+32; yy+=32)
		{
			addObject(new Block(0,yy,ObjectId.Block));
			
			
		}
		for(int xx=200;xx<600; xx+=32)
		{
			addObject(new Block(xx,400,ObjectId.Block));
			
			
		}
	}
	 */
}
