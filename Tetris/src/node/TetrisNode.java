package node;

import java.awt.geom.Rectangle2D;

public class TetrisNode {
	
	private Rectangle2D tetrisNodeRect;
	public static final int DIR_UP = 0;
	public static final int DIR_DOWN = 1;
	public static final int DIR_LEFT = 2;
	public static final int DIR_RIGHT = 3;	
	public static final int NODIR = -1;
	public static final int SIDELENGTH = 10;

	public TetrisNode()
	{
		tetrisNodeRect = new Rectangle2D.Double(10, 10, SIDELENGTH, SIDELENGTH);
	}
	
	public TetrisNode(TetrisNode node, int DIR) {
		
		double headx = 0;
		double heady = 0;
		if (DIR == DIR_UP) {
			headx = node.getTetrisNodeRect().getX();
			heady = node.getTetrisNodeRect().getY() - SIDELENGTH;
		} else if (DIR == DIR_DOWN) {
			headx = node.getTetrisNodeRect().getX();
			heady = node.getTetrisNodeRect().getY() + SIDELENGTH;
		} else if (DIR == DIR_LEFT) {
			headx = node.getTetrisNodeRect().getX() - SIDELENGTH;
			heady = node.getTetrisNodeRect().getY();
		} else if (DIR == DIR_RIGHT) {
			headx = node.getTetrisNodeRect().getX() + SIDELENGTH;
			heady = node.getTetrisNodeRect().getY();
		} else if(DIR == NODIR){
			headx = node.getTetrisNodeRect().getX();
			heady = node.getTetrisNodeRect().getY();
		}

		tetrisNodeRect = new Rectangle2D.Double(headx, heady, SIDELENGTH,
				SIDELENGTH);
	}
	
	public void TetrisNodeMove(int DIR) {
		double headx = 0;
		double heady = 0;
		if (DIR == DIR_UP) {
			headx = tetrisNodeRect.getX();
			heady = tetrisNodeRect.getY() - SIDELENGTH;
		} else if (DIR == DIR_DOWN) {
			headx = tetrisNodeRect.getX();
			heady = tetrisNodeRect.getY() + SIDELENGTH;
		} else if (DIR == DIR_LEFT) {
			headx = tetrisNodeRect.getX() - SIDELENGTH;
			heady = tetrisNodeRect.getY();
		} else if (DIR == DIR_RIGHT) {
			headx = tetrisNodeRect.getX() + SIDELENGTH;
			heady = tetrisNodeRect.getY();
		}

		tetrisNodeRect.setRect(headx, heady, SIDELENGTH, SIDELENGTH);

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
