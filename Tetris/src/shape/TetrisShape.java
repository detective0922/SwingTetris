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

public class TetrisShape {
	
	protected int[][] shapeIndex;
	//private TetrisNode[][] shape;
	protected int gridSize;
	protected int shapeType = -1;
	private TetrisShape shape;

	public TetrisShape() {
		// TODO Auto-generated constructor stub
	}
	
	public TetrisShape(/*Graphics g, */int type/*, int gridSize*/) {
		// TODO Auto-generated constructor stub
		this.shapeType = type;
		//this.shape = new ArrayList<TetrisNode>(length);
		//this.gridSize = gridSize;
		//genShape(g, this.gridSize);
		genShape(this.shapeType);
		initShapeIndexs();
	}
	
	protected int[][] initShapeIndexs(){
		return new int[0][0];
	}
	
	private void genShape(int type){
		
	}
	
	/*private void genShape(Graphics g, int gridSize) {
		shapeIndex = initShapeIndexs();
		int yLen = shapeIndex.length;
		int xLen = shapeIndex[0].length;
		shape = new TetrisNode[yLen][xLen];
		for (int i = 0; i < yLen; i++) {
			for(int j=0;j<xLen;j++){
				if(shapeIndex[i][j] == 1){
					shape[i][j] = new TetrisNode(i*gridSize, j*gridSize);					
				}
			}
		}
	}*/
	
	/*public void draw(Graphics g, Color color, int gridSize) {
		for (TetrisNode[] nodes : shape) {
			for (TetrisNode node : nodes) {
				if (node != null) {
					node.draw(g, color);
				}
			}
		}
		//shapeIndex = initShapeIndexs();
		int yLen = shapeIndex.length;
		int xLen = shapeIndex[0].length;
		shape = new TetrisNode[yLen][xLen];
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				if (shapeIndex[i][j] == 1) {
					shape[i][j] = new TetrisNode(i * gridSize, j * gridSize);
				}
			}
		}
	}*/
	
	/*public void tetrisShapeMove(int DIR, int gridSize) {
		for (TetrisNode[] nodes : shape) {
			for (TetrisNode node : nodes) {
				if (node != null) {
					node.TetrisNodeMoveByDirection(DIR, gridSize);
				}
			}
		}
	}*/
	
	
	public void tetrisShapeRotate(){
		CommUtil.transposeArray(shapeIndex);
	}
	
	//public abstract TetrisShape newInstance(int type, int direct);
	
	/*public TetrisNode[][] getTetrisShape(){
		return shape;
	}*/
		
	public int getTetrisShapeType(){
		return shapeType;
	}
	
	public int[][] getTetrisShapeIndex(){
		return shapeIndex;
	}

}
