package shape;

import node.TetrisNode;

public class LShape extends TetrisShape {

	@Override
	protected void initShapeIndexs() {
		// TODO Auto-generated method stub
		shapeIndex[1][0] = 1;
		shapeIndex[1][1] = 1;
		shapeIndex[1][2] = 1;
		shapeIndex[0][2] = 1;
	}


}
