package tetrisControllor;

import java.util.Random;

import common.TetrisShapeTypes;
import node.TetrisNode;
import shape.TetrisShape;
import tetrisMode.Location;
import tetrisMode.tetrisMode;

public class tetrisControllor {
	private tetrisMode mode;
	
	public tetrisControllor(tetrisMode mode) {
		this.mode = mode;
	}
	
	public void genRandomShape() {

		int type = new Random().nextInt(7);
		int pointDirect = new Random().nextInt(4);
		System.out.println(pointDirect);
		type = TetrisShapeTypes.l;
		TetrisShape randomShape = new TetrisShape(type);
		System.out.println("make new");
		int xmiddle = mode.getWidth() / 2;
		int y = 0;
		Location head = new Location(0, xmiddle);
		mode.addShapeToMode(randomShape, head);
		
	}
	
	/*public void addShapeToMode(tetrisMode mode, TetrisShape shape){
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
	}*/
	
	public void moveShape(int dir){
		mode.moveShape(dir);
	}
	
	public void rotateShape(){
		mode.rotateShape();
	}
	
	
}
	
