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
	
	protected int[][] shapeIndex;
	private TetrisNode[][] shape;
	protected int gridSize;
	protected static int shapeType = -1;

	public TetrisShape() {
		// TODO Auto-generated constructor stub
	}
	
	public TetrisShape(Graphics g, int type, int gridSize) {
		// TODO Auto-generated constructor stub
		this.shapeType = type;
		//this.shape = new ArrayList<TetrisNode>(length);
		this.gridSize = gridSize;
		genShape(g, this.gridSize);
	}
	
	protected abstract int[][] initShapeIndexs();
	
	private void genShape(Graphics g, int gridSize) {
		shapeIndex = initShapeIndexs();
		int yLen = shapeIndex.length;
		int xLen = shapeIndex[0].length;
		shape = new TetrisNode[yLen][xLen];
		for (int i = 0; i < yLen; i++) {
			for(int j=0;j<xLen;j++){
				if(shapeIndex[i][j] == 1){
					shape[i][j] = new TetrisNode(i*gridSize, j*gridSize, gridSize);					
				}
			}
		}
	}
	
	public void draw(Graphics g, Color color) {
		for (TetrisNode[] nodes : shape) {
			for (TetrisNode node : nodes) {
				if (node != null) {
					node.draw(g, color);
				}
			}
		}
	}
	
	public void tetrisShapeMove(int DIR) {
		for (TetrisNode[] nodes : shape) {
			for (TetrisNode node : nodes) {
				if (node != null) {
					node.TetrisNodeMoveByDirection(DIR);
				}				
			}
		}
	}
	
	public void tetrisShapeRotate(){
		CommUtil.transposeArray(shape);
	}
	
	//public abstract TetrisShape newInstance(int type, int direct);
	
	public TetrisNode[][] getTetrisShape(){
		return shape;
	}
		
	public int getTetrisShapeType(){
		return shapeType;
	}

}
