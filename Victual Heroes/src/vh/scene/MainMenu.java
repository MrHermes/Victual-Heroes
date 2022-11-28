package vh.scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import vh.main.GameMain;

public class MainMenu extends GameScene implements SceneMethods {

	private BufferedImage map;
	private BufferedImage sprite;
	private BufferedImage mapIMG;
	private BufferedImage spriteIMG;
	private Random rand;
	
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	
	public MainMenu(GameMain game) {
		super(game);
		importImg();
		this.map = mapIMG;
		this.sprite = spriteIMG;
		loadSprites();
		this.rand = new Random();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(map, 0, 0, null);
		g.drawImage(sprites.get(0), 0, 0, null);
		for (int i = 0 ; i < 16 ; i++) {
			for (int j = 0 ; j < 9; j++){
				g.drawImage(sprites.get(getRX()), i*40, j*40, null);
			}
		}
	}
	
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/croppedmap.jpeg");
		try {
			this.mapIMG = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		is = getClass().getResourceAsStream("/marioatlas.png");
		try {
			this.spriteIMG = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadSprites() {
		for (int i = 0 ; i < 14 ; i++)
		{
			for (int j = 0 ; j < 5 ; j++)
			{
				sprites.add(sprite.getSubimage(i*17, j*29, 17, 29));
			}
		}
	}
	
	private int getRX() {
		return rand.nextInt(14);
	}
	
	private int getRY() {
		return rand.nextInt(5);
	}

}
