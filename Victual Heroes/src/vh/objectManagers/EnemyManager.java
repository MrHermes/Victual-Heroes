package vh.objectManagers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import vh.enemy.Enemy;
import vh.helper.LoadSave;
import vh.scene.Playing;
import static vh.helper.Constants.Direction.*;
import static vh.helper.Constants.Tiles.*;

public class EnemyManager {
	
	private final int ENEMYTOTAL = 4;
	private Playing playing;
	private BufferedImage[] enemyImages;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private Random rand;
	private float speed = 0.5f;
	
	public EnemyManager(Playing plyng) {
		this.playing = plyng;
		this.enemyImages = new BufferedImage[ENEMYTOTAL];
		this.rand = new Random();
		addEnemy(0, 3*48);
		loadEnemyImages();
	}
	
	private void loadEnemyImages() {
		BufferedImage enemyAtlas = LoadSave.getSpriteAtlas();
		enemyImages[0] = enemyAtlas.getSubimage(0 + 9, 48*2, 30, 48);
		enemyImages[1] = enemyAtlas.getSubimage(48*3 + 9, 48*2, 30, 48);
		enemyImages[2] = enemyAtlas.getSubimage(48*6 + 9, 48*2, 30, 48);
		enemyImages[3] = enemyAtlas.getSubimage(48*9 + 9, 48*2, 30, 48);
		
	}
	
	public void addEnemy(int x, int y) {
		int idx = rand.nextInt(0, 4);
		enemies.add(new Enemy(x, y, 0, idx));
	}

	public void update() {
		for (Enemy e : enemies) {
			if (stillRoad(e)) {
				
			}
		}
	}
	
	public boolean stillRoad(Enemy e) {
		int newX = (int) (e.getX() + getSpeedX(e.getLastDir()));
		int newY = (int) (e.getY() + getSpeedY(e.getLastDir()));
		
		if (getTileType(newX, newY) == ENEMYROAD) {
			e.move(speed, e.getLastDir());
		}
		
		else if (isAtEnd(e)) {
			//UDAH SAMPE FINISH
		}
		
		else {
			moveNewDirection(e);
		}
		
		return false;
	}

	private void moveNewDirection(Enemy e) {
		int direction = e.getLastDir();
		int xPos = (int) (e.getX()/16), yPos = (int) (e.getY()/16);
		
		fixEnemyOffset(e, direction, xPos, yPos);
		
		if (direction == LEFT || direction == RIGHT) {
			int newY = (int) (e.getY() + getSpeedY(UP));
			if (getTileType((int) e.getX(), newY) == ENEMYROAD) {
				e.move(speed, UP);
			} else {
				e.move(speed, DOWN);
			}
		}
		
		else {
			int newX = (int) (e.getX() + getSpeedX(RIGHT));
			if (getTileType(newX, (int) e.getY()) == ENEMYROAD) {
				e.move(speed, RIGHT);
			} else {
				e.move(speed, LEFT);
			}
		}
		
	}

	private void fixEnemyOffset(Enemy e, int direction, int xPos, int yPos) {
		
		switch(direction) {
//		case LEFT :
//			if (xPos > 0) xPos--;
//			break;
//		case UP :
//			if (yPos > 0) yPos--;
//			break;
		case RIGHT :
			if (xPos < 28) xPos++;
			break;
		case DOWN :
			if (yPos < 25) yPos++;
			break;
		}
		
		e.setPos(xPos * 16, yPos * 16);
		
	}

	private boolean isAtEnd(Enemy e) {
		// TODO Auto-generated method stub
		return false;
	}

	private int getTileType(int newX, int newY) {
		return playing.getTileType(newX, newY);
	}

	private float getSpeedX(int direction) {
		if (direction == LEFT) {
			return -speed;
		}
		
		else if (direction == RIGHT) {
			return speed + 30;
		}
		
		else {
			return 0;
		}
	}
	
	private float getSpeedY(int direction) {
		if (direction == UP) {
			return -speed;
		}
		
		else if (direction == DOWN) {
			return speed + 48;
		}
		
		else {
			return 0;
		}
	}

	public void draw(Graphics g) {
		for (Enemy e : enemies) {
			drawEnemy(e, g);
		}
	}

	private void drawEnemy(Enemy e, Graphics g) {
		g.drawImage(enemyImages[e.getType()], (int)e.getX(), (int)e.getY(), null);
	}
}
