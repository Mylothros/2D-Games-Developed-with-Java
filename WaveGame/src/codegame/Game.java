package codegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	static final int WIDTH=640;
	static final int HEIGHT=WIDTH/12*9;
	private Thread thread;
	private boolean running=true;
	private Handler handler;
	private Random r;
	private HUD hud;
	public Game()
	{
		this.requestFocus();
		handler =new Handler();
		hud=new HUD();
		this.addKeyListener(new KeyInput(handler));
		Window window=new Window(WIDTH,HEIGHT,"My first game waver!!!",this);
		r=new Random();
		handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player, handler));
		
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
		

	}
	

public synchronized void start(){
	thread=new Thread(this);
	thread.start();
	running=true;
}
	public synchronized void stop()
	{
		try{
			thread.join();//killing the thread
			running=false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
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
		hud.tick();
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
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		hud.render(g);
		g.dispose();
		bs.show();
		
		}
	public static int clamp(int var,int min,int max)
	{
		if(var>=max)
			return var=max;
		else if(var<=min)
		
		return var=min;
		else
			return var;
	}
	public static void main(String args[])
	{
		new Game();
		
	}
}
