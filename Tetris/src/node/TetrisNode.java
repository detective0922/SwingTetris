package node;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import common.Direction;

public class TetrisNode {
	
	private Rectangle2D tetrisNodeRect;
	private int SIDELENGTH;
	
	public TetrisNode(Graphics g, int x, int y, int size) {
		SIDELENGTH = size;
		tetrisNodeRect = new Rectangle2D.Double(x, y, size, size);
	}
	
	public void draw(Graphics g, Color color){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.draw(tetrisNodeRect);
		g2.fill(tetrisNodeRect);
	}
	
	public void TetrisNodeMoveByDirection(int DIR) {
		double headx = 0;
		double heady = 0;
		if (DIR == Direction.DIR_UP) {
			headx = tetrisNodeRect.getX();
			heady = tetrisNodeRect.getY() - SIDELENGTH;
		} else if (DIR == Direction.DIR_DOWN) {
			headx = tetrisNodeRect.getX();
			heady = tetrisNodeRect.getY() + SIDELENGTH;
		} else if (DIR == Direction.DIR_LEFT) {
			headx = tetrisNodeRect.getX() - SIDELENGTH;
			heady = tetrisNodeRect.getY();
		} else if (DIR == Direction.DIR_RIGHT) {
			headx = tetrisNodeRect.getX() + SIDELENGTH;
			heady = tetrisNodeRect.getY();
		}

		TetrisNodeFreeMove((int)headx, (int)heady);
	}
	
	public void TetrisNodeFreeMove(int x, int y) {
		tetrisNodeRect.setRect(x, y, SIDELENGTH, SIDELENGTH);
	}

	
	public Rectangle2D getTetrisNodeRect()
	{
		return this.tetrisNodeRect;
	}
	
	public void setTetrisNodeRect(Rectangle2D tetrisNodeRect)
	{
		this.tetrisNodeRect = tetrisNodeRect;
	}

}
