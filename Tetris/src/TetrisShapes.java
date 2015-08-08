import java.util.ArrayList;




public enum TetrisShapes {
	I(TetrisShapeTypes.i), J(TetrisShapeTypes.j), L(TetrisShapeTypes.l), O(
			TetrisShapeTypes.o), S(TetrisShapeTypes.s), T(TetrisShapeTypes.t), Z(
			TetrisShapeTypes.z);

	private TetrisShapes(int type) {
		// TODO Auto-generated constructor stub
		switch (type) {
		case TetrisShapeTypes.i:
			
			break;
		}
				
	}
	
	public void TetrisShapeMove(int DIR)
	{

		if (DIR == DIR_LEFT) {
			for (TetrisNode node : shape) {
				node.TetrisNodeMove(node, DIR);
			}
		}
		else if(DIR == DIR_RIGHT)
		{
			for (TetrisNode node : shape) {
				node.TetrisNodeMove(node, DIR);
			}
		}			
	}
	
	private ArrayList<TetrisNode> shape = new ArrayList<TetrisNode>(4);
	private static final int DIR_UP = 1;
	private static final int DIR_DOWN = 2;
	private static final int DIR_LEFT = 3;
	private static final int DIR_RIGHT = 4;	

}
