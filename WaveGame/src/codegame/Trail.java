package codegame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {

	private float alpha=1;
	private Color color;
	private Handler handler;
	private int width,height;
	private float life;
	
	public Trail(int x, int y,ID id,Color color,int width,int height,float life,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		this.color=color;
		this.width=width;
		this.life=life;
		this.height=height;
	}

	
	public void tick() {
		if(alpha>life)
		{
			alpha-=life-0.0001f;
		}
		else
		{
			handler.removeObject(this);
		}
		
	}


	public void render(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		g2d.setComposite(mekeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g2d.setComposite(mekeTransparent(1));
	}

	private AlphaComposite mekeTransparent(float alpha)
	{
		int type=AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type,alpha));
	}

	public Rectangle getBounds() {
		
		return null;
	}

	
}
