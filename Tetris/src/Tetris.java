import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.util.*;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;
import javax.swing.Timer;

import common.Direction;
import node.TetrisNode;
import shape.TetrisShape;
import tetrisControllor.tetrisControllor;
import tetrisMode.tetrisMode;
import tetrisView.tetrisView;

public class Tetris {
	public static void main(String args[]) {
		
		//devide to view
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				TetrisFrame frame = new TetrisFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});

	}
}


class TetrisFrame extends JFrame
{
	public TetrisFrame()
	{
		setTitle("Tetris");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		TetrisComponent component = new TetrisComponent();
		add(component);
	
	}
	
	private static final int DEFAULT_WIDTH = 216;
	private static final int DEFAULT_HEIGHT = 238;
}

class TetrisComponent extends JComponent
{
	
	private TetrisShape randomShape;
	private static int rowCount = 20;
	private ArrayList<ArrayList<TetrisNode>> existedNodes = new ArrayList<ArrayList<TetrisNode>>(
			rowCount);
	private static final int SIDELENGTH = 10;
	private static boolean isMoved = false;
	private static final int DELAY = 1000;
	private static int rotate = -1;
	private tetrisControllor controllor;
	private tetrisMode mode;
	private tetrisView view;
	
	public TetrisComponent()
	{
		
		this.mode = new tetrisMode(32,32);
		this.view = new tetrisView(mode);
		this.controllor = new tetrisControllor(mode);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Tetris");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
		
		//initExistedNodes();
		controllor.genRandomShape();
		
		ActionListener listener = new TimerListener();
		Timer t = new Timer(DELAY, listener);
		t.start();
		
		this.setFocusable(true);
		//this.setOpaque(false);
		//this.requestFocusInWindow();
		addKeyListener(new tetrisKeyListener());		
		repaint();
		
	}
	
	/*public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		
		for(ArrayList<TetrisNode> ylist : existedNodes){
			for(TetrisNode node : ylist){
				if(node != null){
					g2.draw(node.getTetrisNodeRect());
				}
			}
		}
		
		for(TetrisNode Node: randomShape.getTetrisShape())
		{					
			g2.draw(Node.getTetrisNodeRect());		
		}
				
	}*/
	
	/*public void makeRandomShape()
	{
		if(randomShape == null)
		{					
			int type = new Random().nextInt(7);
			int pointDirect = new Random().nextInt(4);
			System.out.println(pointDirect);
			type = TetrisShapeTypes.i;
			randomShape = shapeFactory.getTetrisShape(type, pointDirect);	
			System.out.println("make new");
		}	
	}*/
	
	/*public void randomShapeMove() 
	{
		if (isBottom(randomShape)) {
			TetrisShape tmpShape  = new TetrisShape(randomShape) {
				
				@Override
				public void tetrisRotate(int direct) {
					// TODO Auto-generated method stub					
				}

				@Override
				public TetrisShape newInstance(int type, int direct) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			addShapeToExist(tmpShape);
			System.out.println("addShapeToExist");
			if (isBottomFull()) {
				removeBottomLine();
			}
			randomShape = null;
			makeRandomShape();
		} else {
			randomShape.tetrisShapeMove(TetrisNode.DIR_DOWN);
		}
		repaint();

	}*/
	
	/*private boolean isBottom(TetrisShape shape)
	{
		for(TetrisNode node : shape.getTetrisShape()){
			double nodeX = node.getTetrisNodeRect().getCenterX();
			double nodeY = node.getTetrisNodeRect().getCenterY();
			int xIndex = (int) (nodeX / 10);
			int existedY = (rowCount - existedNodes.get(xIndex).size() - 1)
					* TetrisNode.SIDELENGTH;
			System.out.println(nodeY+", " + existedY);
			if (nodeY >= existedY) {
				System.out.println("bottom");
				return true;			
			}
		}
		System.out.println("shpae scaned");
		return false;
	}*/
	
	private boolean isBottomFull() {
		for(ArrayList<TetrisNode> ylist: existedNodes){
			if (ylist.size() == 0 || ylist.get(0) == null)
				return false;

		}
		return true;
	}
	
	private void removeBottomLine(){
		for (ArrayList<TetrisNode> ylist : existedNodes) {
			if (ylist.size() == 1) {
				ylist.set(0, null);
			} else {
				for (int i = 0; i < ylist.size()-1; i++) {
					ylist.set(i, ylist.get(i + 1));
				}
			}
		}
	}
	
	/*private void addShapeToExist(TetrisShape shape){
		for (TetrisNode node : shape.getTetrisShape()) {
			double nodeX = node.getTetrisNodeRect().getCenterX();
			int xIndex = (int) (nodeX / 10);
			existedNodes.get(xIndex).add(node);
			System.out.println("add node");
		}
	}*/
	
	private void initExistedNodes(){
		for (int i = 0; i < rowCount; i++) {
			existedNodes.add(new ArrayList<TetrisNode>());
		}
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			//randomShapeMove();
		}
	}
	
	private class tetrisKeyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent e){  
	        if(e.getKeyCode() == KeyEvent.VK_UP)
	        {
	        	
	        }
	        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
	        {
				//randomShape.tetrisShapeMove(TetrisNode.DIR_DOWN);
	        	controllor.moveShape(Direction.DIR_DOWN);
	        }
	        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
	        {
				/*randomShape.tetrisShapeMove(TetrisNode.DIR_LEFT);
				isMoved = true;*/
	        	controllor.moveShape(Direction.DIR_LEFT);
	        }
	        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	        {
				/*randomShape.tetrisShapeMove(TetrisNode.DIR_RIGHT);
				isMoved = true;*/
	        	controllor.moveShape(Direction.DIR_RIGHT);
	        }
	        else if(e.getKeyCode() == KeyEvent.VK_R)
	        {
				/*rotate++;
				int direct = rotate % 4;
				randomShape.tetrisRotate(direct);
				isMoved = true;*/
	        	controllor.rotateShape();
	        }
	        repaint();
	    } 
	}
	
}

