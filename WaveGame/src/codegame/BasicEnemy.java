package codegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {


	private Handler handler;
	public BasicEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		velx=5;
		vely=5;
		this.handler=handler;
	}

	public void tick() {
	
		x+=velx;
		y+=vely;
		
		if(y<=0||y>=Game.HEIGHT-32)
		{
			vely*=-1;
		}
		if(x<=0||x>=Game.WIDTH-16)
		{
			velx*=-1;
		}
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.02f,handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,16,16);
	}
}
