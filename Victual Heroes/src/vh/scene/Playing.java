package vh.scene;

import java.awt.Color;
import java.awt.Graphics;

import vh.main.GameMain;

public class Playing extends GameScene implements SceneMethods {

	public Playing(GameMain game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 640, 640);
		g.setColor(Color.BLACK);
		g.drawString("PLAYING TAB", 320, 320);
	}

}
