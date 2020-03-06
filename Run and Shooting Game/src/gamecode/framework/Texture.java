package gamecode.framework;

import java.awt.image.BufferedImage;

import gamecode.windows.BufferedImageLoader;

public class Texture {

	SpriteSheet bs,ps;
	private BufferedImage block_sheet=null;
	private BufferedImage player_sheet=null;
	public BufferedImage[] block = new BufferedImage[2];
	public BufferedImage[] player = new BufferedImage[7];
	public Texture()
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			block_sheet=loader.loadImage("/block_sheet.png");
			player_sheet=loader.loadImage("/player_sheet.png");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		bs=new SpriteSheet(block_sheet);

		ps=new SpriteSheet(player_sheet);
		getTextures();
	}
	private void getTextures()
	{
		block[0]=bs.grabImage(1, 1, 32, 32);
		block[1]=bs.grabImage(2, 1, 32, 32);
		player[0]=ps.grabImage(1, 1, 32, 64);
		player[1]=ps.grabImage(2, 1, 32, 64);
		player[2]=ps.grabImage(3, 1, 32, 64);
		player[3]=ps.grabImage(4, 1, 32, 64);
		player[4]=ps.grabImage(5, 1, 32, 64);
		player[5]=ps.grabImage(6, 1, 32, 64);
		player[6]=ps.grabImage(7, 1, 32, 64);
	}
}
