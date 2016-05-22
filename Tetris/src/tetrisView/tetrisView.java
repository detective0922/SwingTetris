package tetrisView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import shape.TetrisShape;
import tetrisMode.tetrisMode;

public class tetrisView extends JPanel{
	
	private static final int GRID_SIZE = 16;
	private tetrisMode mode;
	
	public tetrisView(tetrisMode tetrisMode) {
		this.mode = tetrisMode;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GRAY);
		for (int row = 0; row < mode.getHeight(); row++) {
			g.drawLine(0, row * GRID_SIZE, mode.getWidth() * GRID_SIZE, row * GRID_SIZE);
		}
		for (int col = 0; col < mode.getWidth(); col++) {
			g.drawLine(col * GRID_SIZE, 0, col * GRID_SIZE, mode.getHeight() * GRID_SIZE);
		}
		for (int row = 0; row < mode.getHeight(); row++) {
			for (int col = 0; col < mode.getWidth(); col++) {
				TetrisShape shape = mode.get(row, col);
				if (shape != null) {
					shape.draw(g, Color.BLACK);
				}
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(mode.getWidth()*GRID_SIZE+1, mode.getHeight()*GRID_SIZE+1);
	}

}
