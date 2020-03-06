package gamecode.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.logging.Handler;

public abstract class GameObject {

		protected float x,y;
		protected float velX=0,velY=0;
		protected ObjectId id;
		protected boolean falling = true;
		protected boolean jumping =false;
		public boolean setJumping;
		protected static Handler handler;
		protected int facing=1;
		
		
	
		public float getX() {
			return x;
		}
		public void setX(float x) {
			this.x = x;
		}
		public float getY() {
			return y;
		}
		public void setY(float y) {
			this.y = y;
		}
		public float getVelX() {
			return velX;
		}
		public void setVelX(float velX) {
			this.velX = velX;
		}
		public float getVelY() {
			return velY;
		}
		public void setVelY(float velY) {
			this.velY = velY;
		}
		public ObjectId getId() {
			return id;
		}
		public void setId(ObjectId id) {
			this.id = id;
		}
		public boolean isFalling() {
			return falling;
		}
		public void setFalling(boolean falling) {
			this.falling = falling;
		}
		public boolean isJumping() {
			return jumping;
		}
		public void setJumping(boolean jumping) {
			this.jumping = jumping;
		}
		public static Handler getHandler() {
			return handler;
		}
		public static void setHandler(Handler handler) {
			GameObject.handler = handler;
		}
		public GameObject(float x,float y,ObjectId id)
		{
			
			this.x=x;
			this.y=y;
			this.id=id;
			
		}
		public abstract void tick(LinkedList<GameObject> object);//collisions
		public abstract void render(Graphics g);
		public abstract Rectangle getBounds();
		public int getFacing() {
			return facing;
		}
		public void setFacing(int facing) {
			this.facing = facing;
		}
		
		
	
}
