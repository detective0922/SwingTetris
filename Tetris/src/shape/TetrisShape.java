package shape;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import node.TetrisNode;

public abstract class TetrisShape {
	
	protected ArrayList<TetrisNode> shape = new ArrayList<TetrisNode>(4);
	protected TetrisNode firstNode;
	protected TetrisNode secondNode;
	protected TetrisNode thirdNode;
	protected TetrisNode fourthNode;
	protected static int shapeType = -1;
	protected static int pointDirect = -1;
	public static final int POINT_UP = 0;
	public static final int POINT_RIGHT = 1;
	public static final int POINT_DOWN = 2;
	public static final int POINT_LEFT = 3;

	public TetrisShape() {
		// TODO Auto-generated constructor stub
	}
	
	public TetrisShape(int type, int direct) {
		// TODO Auto-generated constructor stub
		this.shapeType = type;
		this.pointDirect = direct;
	}
	
	public TetrisShape(TetrisShape orgShape) {
		// TODO Auto-generated constructor stub
		this.shapeType = orgShape.getTetrisShapeType();
		this.pointDirect = orgShape.getTetrisDirect();
		
		this.firstNode = new TetrisNode(orgShape.getFirstNode(), TetrisNode.NODIR);
		this.secondNode = new TetrisNode(orgShape.getSecondNode(), TetrisNode.NODIR);
		this.thirdNode = new TetrisNode(orgShape.getThirdNode(), TetrisNode.NODIR);
		this.fourthNode = new TetrisNode(orgShape.getFourthNode(), TetrisNode.NODIR);
		
		addNoteToShape();
		
	}
	
	protected void addNoteToShape() {
		shape.add(firstNode);
		shape.add(secondNode);
		shape.add(thirdNode);
		shape.add(fourthNode);
	}
	
	public void tetrisShapeMove(/*Rectangle2D bounds, */int DIR)
	{
		/*(for (TetrisNode node : shape) {
			if (node.getTetrisNodeRect().getY() >= bounds.getMaxY()
					|| (node.getTetrisNodeRect().getY() + TetrisNode.SIDELENGTH) >= bounds
							.getMaxY())
				return false;
		}*/

		if (DIR == TetrisNode.DIR_DOWN) {
			for (TetrisNode node : shape) {
				node.TetrisNodeMove(DIR);
			}
		} else if (DIR == TetrisNode.DIR_LEFT) {
			for (TetrisNode node : shape) {
				node.TetrisNodeMove(DIR);
			}
		} else if (DIR == TetrisNode.DIR_RIGHT) {
			for (TetrisNode node : shape) {
				node.TetrisNodeMove(DIR);
			}
		}
		//return true;
	}
	
	public abstract void tetrisRotate(int direct);
	
	public abstract TetrisShape newInstance(int type, int direct);
	
	public List<TetrisNode> getTetrisShape(){
		return shape;
	}
	
	public int getTetrisShapeType(){
		return shapeType;
	}
	
	public int getTetrisDirect(){
		return pointDirect;
	}
	
	public TetrisNode getFirstNode(){
		return firstNode;
	}
	
	public TetrisNode getSecondNode(){
		return secondNode;
	}
	
	public TetrisNode getThirdNode(){
		return thirdNode;
	}
	
	public TetrisNode getFourthNode(){
		return fourthNode;
	}

}
