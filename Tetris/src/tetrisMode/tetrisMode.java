package tetrisMode;

import java.util.ArrayList;
import java.util.List;

import common.Direction;
import node.TetrisNode;
import shape.TetrisShape;

public class tetrisMode {
	
	private int width;
	private int height;
	private int[][] field;
	private TetrisNode[][] nodes;
	private TetrisShape shape;
	private Location[][] shapeLoc;
	
	public tetrisMode(int width, int height) {
		this.width = width;
		this.height = height;
		field = new int[height][width];
		nodes = new TetrisNode[height][width];
		shape = null;
		shapeLoc =  new Location[0][0];
		clear();
		Update();
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	private int setShapeNode(Location loc, int o) {
		int row = loc.getRow();
		int col = loc.getCol();
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
	
	public TetrisNode getNode(Location loc) {
		return nodes[loc.getRow()][loc.getCol()];
	}
	
	public TetrisNode getFieldNode(int row, int col) {
		return nodes[row][col];
	}
	
	private void clear() {
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				field[row][col] = -1;
				nodes[row][col] = null;
			}
		}
	}
	
	private void Update(){
		clear();
		updateFieldByShape();
		updateNodesByField();
		deleteBottom();
	}
	
	private void updateFieldByShape() {
		int yLen = shapeLoc.length;
		if(yLen == 0){
			return;
		}
		int xLen = shapeLoc[0].length;
		int[][] shapeIndex = shape.getTetrisShapeIndex();
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				int row = shapeLoc[i][j].getRow();
				int col = shapeLoc[i][j].getCol();
				field[row][col] = shapeIndex[i][j];
			}
		}
	}
	
	private void updateNodesByField() {
		int yLen = field.length;
		int xLen = field[0].length;		
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
	
	public void addShapeToMode(TetrisShape shape, Location head){
		this.shape = shape;
		int[][] shapeIndex = this.shape.getTetrisShapeIndex();
		int yLen = shapeIndex.length;
		int xLen = shapeIndex[0].length;
		shapeLoc = new Location[yLen][xLen];
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				shapeLoc[i][j] = new Location(head.getRow() + i, head.getCol() + j);
				this.setShapeNode(shapeLoc[i][j], shapeIndex[i][j]);
			}
		}
		updateNodesByField();
	}
	
	/*private int[][] getShape() {
		int yLen = shapeLoc.length;
		int xLen = shapeLoc[0].length;
		int[][] shapeIndex = new int[yLen][xLen];
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				int row = shapeLoc[i][j].getRow();
				int col = shapeLoc[i][j].getCol();
				shapeIndex[i][j] = field[row][col];
			}
		}
		return shapeIndex;
	}*/
	
	public void moveShape(int dir){
		int moveX = 0;
		int moveY = 0;
		if (dir == Direction.DIR_UP) {
			moveX = 0;
			moveY = -1;
		} else if (dir == Direction.DIR_DOWN) {
			moveX = 0;
			moveY = 1;
		} else if (dir == Direction.DIR_LEFT) {
			moveX = -1;
			moveY = 0;
		} else if (dir == Direction.DIR_RIGHT) {
			moveX = 1;
			moveY = 0;
		}
		int yLen = shapeLoc.length;
		int xLen = shapeLoc[0].length;
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				int row = shapeLoc[i][j].getRow();
				int col = shapeLoc[i][j].getCol();
				shapeLoc[i][j].setCol(col + moveX);
				shapeLoc[i][j].setRow(row + moveY);
				
			}
		}
		Update();
	}
	
	public void rotateShape(){
		shape.tetrisShapeRotate();
		Update();
	}
	
	public boolean isBottomFull(){
		return false;
	}
	
	public void deleteBottom(){
		//need to implement
		if(isBottomFull())
			deleteBottom();
		
	}

}
