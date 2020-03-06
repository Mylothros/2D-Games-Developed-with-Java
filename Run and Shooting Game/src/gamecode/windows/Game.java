package gamecode.windows;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import gamecode.framework.KeyInput;
import gamecode.framework.ObjectId;
import gamecode.framework.Texture;
import gamecode.objects.Block;
import gamecode.objects.Player;


public class Game extends Canvas implements Runnable {

	private boolean running=false;
	private Thread thread;
	Handler handler;
	Camera cam;
	static Texture text;
	public static int WIDTH,HEIGHT;
	private BufferedImage level= null,clouds=null;
	Block test;
	private void init()
	{
		WIDTH=getWidth();
		HEIGHT=getHeight();
		text=new Texture();
		BufferedImageLoader loader=new BufferedImageLoader();
		level=loader.loadImage("/level.png");
		
		clouds=loader.loadImage("/background...png");
		
		handler=new Handler();
		cam=new Camera(0,0);
		//handler.addObject(new Player(100,100,handler,ObjectId.Player));
		//handler.createLevel();
		LoadImageLever(level);
		this.addKeyListener(new KeyInput(handler));
	
	}
	public synchronized void start()
	{
		if(running)
			return;
		
		running=true;
		thread=new Thread(this);
		thread.start();
	}
	
	public void run() {	
		init();
		this.requestFocus();
		long lastTime=System.nanoTime();
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double delta=0;
		long timer=System.currentTimeMillis();
		int frames=0;
		while(running){
		long now =System.nanoTime();
		delta+=(now - lastTime)/ns;
		lastTime=now;
		while(delta>=1)
		{
			tick();
			delta--;
		}
		if(running){
			render();
			frames++;
			
		}
		if(System.currentTimeMillis()-timer>1000)
		{
			timer+= 1000;
			System.out.println("FPS:"+frames+"  TICKS:"+amountOfTicks);
			frames=0;
		}
		}
	
		}
		private void tick()
		{
			handler.tick();
			for(int i=0;i<handler.object.size(); i++)
			{
				if(handler.object.get(i).getId()==ObjectId.Player){
				cam.tick((handler.object.get(i)));
				}
			}
			
		}
		private void render()
		{
			BufferStrategy bs=this.getBufferStrategy();
			if(bs==null)
			{
				this.createBufferStrategy(3);
				return;	
			}
			Graphics g=bs.getDrawGraphics();
			Graphics2D g2d=(Graphics2D) g;
			
			g.setColor(newColor(25,191,224));
			g.fillRect(0, 0,getWidth(), getHeight());
			
			g2d.translate(cam.getX(),cam.getY());
			for(int xx=0;xx<clouds.getWidth()*30 ;xx+=clouds.getWidth())
			{
				g.drawImage(clouds,xx,50,this);
				
			}
			handler.render(g);
			
			g2d.translate(-cam.getX(),-cam.getY());
			g.dispose();
			bs.show();
		}
		private Color newColor(int i, int j, int k) {
			// TODO Auto-generated method stub
			return null;
		}
		private void LoadImageLever(BufferedImage image)
		{
			int w=image.getWidth();
			int h=image.getHeight();
		for(int xx=0; xx<h; xx++)
		{
			for(int yy=0;yy<w;yy++)
			{
				int pixel=image.getRGB(xx, yy);
				int red=(pixel>>16) & 0xff;
				int green=(pixel>>8) & 0xff;
				int blue=(pixel) & 0xff;
				
				if(red==255 && green ==255 & blue == 255) handler.addObject(new Block(xx*32,yy*32,1,ObjectId.Block, handler));
				if(red==0 && green ==0 & blue == 255) handler.addObject(new Player(xx*32,yy*32,handler,ObjectId.Player));
				
			}
			
		}
		}
	public static Texture getInstance()
	
	{
		return text;
	}
public static void main(String args[])
{
	Window window=new Window(800,600,"Babis Platform", new Game());

}
}
