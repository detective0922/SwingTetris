package tetrisControllor;

import java.util.Random;

import common.TetrisShapeTypes;
import node.TetrisNode;
import shape.TetrisShape;
import tetrisMode.tetrisMode;

public class tetrisControllor {
	private tetrisMode mode;
	private static final int DEFAULT_WIDTH = 256;
	private static final int DEFAULT_HEIGHT = 256;
	
	public tetrisControllor() {
		mode = new tetrisMode(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public TetrisShape genRandomShape() {

		int type = new Random().nextInt(7);
		int pointDirect = new Random().nextInt(4);
		System.out.println(pointDirect);
		type = TetrisShapeTypes.i;
		TetrisShape randomShape = new TetrisShape(type);
		System.out.println("make new");
		return randomShape;
		
	}
	
	public void addShapeToMode(tetrisMode mode, TetrisShape shape){
		int[][] shapeIndex = shape.getTetrisShapeIndex();
		int yLen = shapeIndex.length;
		int xLen = shapeIndex[0].length;
		int middle = mode.getWidth() / 2;
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				if (shapeIndex[i][j] == 1) {
					mode.set(middle + i, j, 1);
				}
			}
		}
	}
	
	public void moveShape(tetrisMode mode, TetrisShape shape){
		
	}
	
	public void rotateShape(tetrisMode mode, TetrisShape shape){
		
	}
	
	
}
	
