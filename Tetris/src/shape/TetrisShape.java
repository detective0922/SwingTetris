package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.CommUtil;
import common.Direction;
import node.TetrisNode;

public abstract class TetrisShape {
	
	protected TetrisNode[][] shape = new TetrisNode[4][4];
	protected int gridSize;
	protected static int shapeType = -1;

	public TetrisShape() {
		// TODO Auto-generated constructor stub
	}
	
	public TetrisShape(int type, int gridSize) {
		// TODO Auto-generated constructor stub
		this.shapeType = type;
		//this.shape = new ArrayList<TetrisNode>(length);
		this.gridSize = gridSize;
		genShape(this.gridSize);
	}
	
	protected abstract void genShape(int gridSize);
	
	public void draw(Graphics g, Color color){
		for (TetrisNode[] nodes : shape) {
			for(TetrisNode node:nodes){
				node.draw(g, color);
			}
		}
	}
	
	public void tetrisShapeMove(int DIR) {
		for (TetrisNode[] nodes : shape) {
			for (TetrisNode node : nodes) {
				node.TetrisNodeMoveByDirection(DIR);
			}
		}
	}
	
	public void tetrisShapeRotate(){
		CommUtil.transposeArray(shape);
	}
	
	public abstract TetrisShape newInstance(int type, int direct);
	
	public TetrisNode[][] getTetrisShape(){
		return shape;
	}
		
	public int getTetrisShapeType(){
		return shapeType;
	}

}
