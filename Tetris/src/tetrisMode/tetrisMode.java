package tetrisMode;

import node.TetrisNode;
import shape.TetrisShape;

public class tetrisMode {
	
	private int width;
	private int height;
	private int[][] field;
	private TetrisNode[][] nodes;
	
	public tetrisMode(int width, int height) {
		this.width = width;
		this.height = height;
		field = new int[height][width];
		//nodes = new TetrisNode[height][width];
		updateShape();
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public int set(int row, int col, int o) {
		int ret = field[row][col];
		field[row][col] = o;
		if (field[row][col] == 1) {
			nodes[row][col] = new TetrisNode();
		} else {
			nodes[row][col] = null;
		}
		return ret;
	}
	
	/*public int get(int row, int col) {
		return field[row][col];
	}*/
	
	public TetrisNode getNode(int row, int col) {
		return nodes[row][col];
	}
	
	private void updateShape() {
		int yLen = field.length;
		int xLen = field[0].length;
		nodes = new TetrisNode[yLen][xLen];
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				if (field[i][j] == 1) {
					nodes[i][j] = new TetrisNode();
				} else {
					nodes[i][j] = null;
				}
			}
		}
	}

}
