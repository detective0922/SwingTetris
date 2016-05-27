package tetrisControllor;

import java.util.Random;

import common.TetrisShapeTypes;
import shape.TetrisShape;
import tetrisMode.tetrisMode;

public class tetrisControllor {
	private tetrisMode mode;
	private static final int DEFAULT_WIDTH = 256;
	private static final int DEFAULT_HEIGHT = 256;
	
	public tetrisControllor() {
		mode = new tetrisMode(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public void genRandomShape()
	{
				
		int type = new Random().nextInt(7);
		int pointDirect = new Random().nextInt(4);
		System.out.println(pointDirect);
		type = TetrisShapeTypes.i;
		TetrisShape randomShape = new TetrisShape(type);
		System.out.println("make new");
			
	}
	

}
