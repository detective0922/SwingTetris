package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Direction;
import node.TetrisNode;

public abstract class TetrisShape {
	
	protected List<TetrisNode> shape;
	protected int gridSize;
	/*protected TetrisNode firstNode;
	protected TetrisNode secondNode;
	protected TetrisNode thirdNode;
	protected TetrisNode fourthNode;*/
	protected static int shapeType = -1;

	public TetrisShape() {
		// TODO Auto-generated constructor stub
	}
	
	public TetrisShape(int type, int length, int gridSize) {
		// TODO Auto-generated constructor stub
		this.shapeType = type;
		this.shape = new ArrayList<TetrisNode>(length);
		this.gridSize = gridSize;
		genShape(this.gridSize);
	}
	
	protected abstract void genShape(int gridSize);
	
	public void draw(Graphics g, Color color){
		for (TetrisNode node : shape) {
			node.draw(g, color);;
		}
	}
	
	public void tetrisShapeMove(int DIR)
	{
		if (DIR == Direction.DIR_DOWN) {
			for (TetrisNode node : shape) {
				node.TetrisNodeMoveByDirection(DIR);
			}
		} else if (DIR == Direction.DIR_LEFT) {
			for (TetrisNode node : shape) {
				node.TetrisNodeMoveByDirection(DIR);
			}
		} else if (DIR == Direction.DIR_RIGHT) {
			for (TetrisNode node : shape) {
				node.TetrisNodeMoveByDirection(DIR);
			}
		}
		//return true;
	}
	
	public void tetrisShapeRotate(){
		for(int i = 1; i<=shape.size();i++){
			shape.get(i).TetrisNodeRotate(gridSize*i);
		}
	}
	
	public abstract TetrisShape newInstance(int type, int direct);
	
	public List<TetrisNode> getTetrisShape(){
		return shape;
	}
	
	public int getTetrisShapeType(){
		return shapeType;
	}

}
