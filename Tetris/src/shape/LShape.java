package shape;

import node.TetrisNode;

public class LShape extends TetrisShape {

	@Override
	protected int[][] initShapeIndexs() {
		// TODO Auto-generated method stub
		int[][] retArray = { 
				{ 0, 0, 1, 0 }, 
				{ 1, 1, 1, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 } 
				};

		return retArray;
	}


}
