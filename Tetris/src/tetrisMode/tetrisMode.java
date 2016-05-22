package tetrisMode;

import shape.TetrisShape;

public class tetrisMode {
	
	private int width;
	private int height;
	private TetrisShape[][] field;
	
	public tetrisMode(int width, int height) {
		this.width = width;
		this.height = height;
		field = new TetrisShape[height][width];
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public TetrisShape set(int row, int col, TetrisShape o) {
		TetrisShape ret = field[row][col];
		field[row][col] = o;
		return ret;
	}
	
	public TetrisShape get(int row, int col) {
		return field[row][col];
	}

}
