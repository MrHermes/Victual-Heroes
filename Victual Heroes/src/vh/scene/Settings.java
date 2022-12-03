package vh.scene;

import static vh.main.GameStates.*;

import java.awt.Color;
import java.awt.Graphics;

import vh.main.GameMain;
import vh.ui.Button;

public class Settings extends GameScene implements SceneMethods {
	
	private Button backButton;

	public Settings(GameMain game) {
		super(game);
		initializeButton();
	}
	
	private void initializeButton() {

		int x = 1024;
		int y = 576;
		
		int buttonWidth = 100;
		int buttonHeight = 30;
		
		backButton = new Button("← Back", 0, 0, buttonWidth, buttonHeight, 0);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1024, 676);
		g.setColor(Color.WHITE);
		g.drawString("SETTINGS TAB", 512, 338);
		drawButtons(g);
	}

	private void drawButtons(Graphics g) {
		backButton.draw(g);
	}

	@Override
	public void mouseClicked(int x, int y) {
		if(backButton.getBounds().contains(x, y)) {
			setGameState(MENU);
		}
	}

	@Override
	public void mouseMoved(int x, int y) {
		backButton.setMouseOverButton(false);
		if(backButton.getBounds().contains(x, y)) {
			backButton.setMouseOverButton(true);
		}
		
	}

	@Override
	public void mousePressed(int x, int y) {
		if(backButton.getBounds().contains(x, y)) {
			setGameState(MENU);
		}	
	}

	@Override
	public void mouseReleased(int x, int y) {
		backButton.resetMouseState();
	}

	@Override
	public void keyTyped(int n) {
		// TODO Auto-generated method stub
		
	}

}
