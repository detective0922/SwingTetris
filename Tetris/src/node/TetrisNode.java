package node;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import common.Direction;

public class TetrisNode {
	
	//private Rectangle2D tetrisNodeRect;
	/*private int nodeX;
	private int nodeY;*/
	//private int SIDELENGTH;
	
	public TetrisNode(/*int x, int y*/) {
		//SIDELENGTH = size;
		/*nodeX = x;
		nodeY = y;*/
	}
	
	public void draw(Graphics g, Color color,int nodeX, int nodeY, int size){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		/*g2.draw(tetrisNodeRect);
		g2.fill(tetrisNodeRect);*/
		g2.drawRect(nodeX, nodeY, size, size);
		g2.fillRect(nodeX, nodeY, size, size);
		
	}
	
	/*public void TetrisNodeMoveByDirection(int DIR, int size) {
		double headx = 0;
		double heady = 0;
		if (DIR == Direction.DIR_UP) {
			headx = nodeX;
			heady = nodeY - size;
		} else if (DIR == Direction.DIR_DOWN) {
			headx = nodeX;
			heady = nodeY + size;
		} else if (DIR == Direction.DIR_LEFT) {
			headx = nodeX - size;
			heady = nodeY;
		} else if (DIR == Direction.DIR_RIGHT) {
			headx = nodeX + size;
			heady = nodeY;
		}

		TetrisNodeFreeMove((int)headx, (int)heady);
	}
	
	public void TetrisNodeFreeMove(int x, int y) {
		nodeX = x;
		nodeY = y;
	}*/

	
	/*public Rectangle2D getTetrisNodeRect()
	{
		return this.tetrisNodeRect;
	}*/
	
	/*public void setTetrisNodeRect(Rectangle2D tetrisNodeRect)
	{
		this.tetrisNodeRect = tetrisNodeRect;
	}*/

}
