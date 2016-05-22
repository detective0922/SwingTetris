package shape;

import node.TetrisNode;

public class IShape extends TetrisShape {

	@Override
	protected void initShapeIndexs() {
		// TODO Auto-generated method stub
		shapeIndex[0][1] = 1;
		shapeIndex[1][1] = 1;
		shapeIndex[2][1] = 1;
		shapeIndex[3][1] = 1;
	}
}
