package shape;

import node.TetrisNode;

public class OShape extends TetrisShape {

	public OShape() {
		// TODO Auto-generated constructor stub
	}

	public OShape(int type, int direct) {
		super(type, direct);
		// TODO Auto-generated constructor stub
		thirdNode = new TetrisNode();
		switch (pointDirect) {
		case POINT_LEFT:
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_UP);
			firstNode = new TetrisNode(secondNode, TetrisNode.DIR_LEFT);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_LEFT);
			break;
		case POINT_UP:
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_RIGHT);
			firstNode = new TetrisNode(secondNode, TetrisNode.DIR_UP);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_UP);
			break;
		case POINT_RIGHT:
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_DOWN);
			firstNode = new TetrisNode(secondNode, TetrisNode.DIR_RIGHT);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_RIGHT);
			break;
		case POINT_DOWN:
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_LEFT);
			firstNode = new TetrisNode(secondNode, TetrisNode.DIR_DOWN);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_DOWN);
			break;			
		}
		addNoteToShape();
	}

	@Override
	public void tetrisRotate(int direct) {
		// TODO Auto-generated method stub
		thirdNode = shape.get(2);
		switch (direct) {
		case POINT_LEFT:
			/*shape.set(1, new TetrisNode(thirdNode, TetrisNode.DIR_UP));
			shape.set(0, new TetrisNode(secondNode, TetrisNode.DIR_LEFT));
			shape.set(3, new TetrisNode(thirdNode, TetrisNode.DIR_LEFT));*/
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_UP);
			firstNode = new TetrisNode(secondNode, TetrisNode.DIR_LEFT);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_LEFT);
			break;
		case POINT_UP:
			/*shape.set(1, new TetrisNode(thirdNode, TetrisNode.DIR_RIGHT));
			shape.set(0, new TetrisNode(secondNode, TetrisNode.DIR_UP));
			shape.set(3, new TetrisNode(thirdNode, TetrisNode.DIR_UP));*/
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_RIGHT);
			firstNode = new TetrisNode(secondNode, TetrisNode.DIR_UP);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_UP);
			break;
		case POINT_RIGHT:
			/*shape.set(1, new TetrisNode(thirdNode, TetrisNode.DIR_DOWN));
			shape.set(0, new TetrisNode(thirdNode, TetrisNode.DIR_DOWN));
			shape.set(3, new TetrisNode(thirdNode, TetrisNode.DIR_RIGHT));*/
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_DOWN);
			firstNode = new TetrisNode(thirdNode, TetrisNode.DIR_DOWN);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_RIGHT);
			break;
		case POINT_DOWN:
			/*shape.set(1, new TetrisNode(thirdNode, TetrisNode.DIR_LEFT));
			shape.set(0, new TetrisNode(secondNode, TetrisNode.DIR_DOWN));
			shape.set(3, new TetrisNode(thirdNode, TetrisNode.DIR_DOWN));*/
			secondNode = new TetrisNode(thirdNode, TetrisNode.DIR_LEFT);
			firstNode = new TetrisNode(secondNode, TetrisNode.DIR_DOWN);
			fourthNode = new TetrisNode(thirdNode, TetrisNode.DIR_DOWN);
			break;			
		}
		shape.set(0, firstNode);
		shape.set(1, secondNode);
		shape.set(3, fourthNode);
	}

	@Override
	public TetrisShape newInstance(int type, int direct) {
		// TODO Auto-generated method stub
		return new OShape(type, direct);
	}

}
