package tetrisMode;

import java.util.HashMap;
import java.util.Map;

import shape.IShape;
import shape.JShape;
import shape.LShape;
import shape.OShape;
import shape.SShape;
import shape.TShape;
import shape.TetrisShape;
import shape.TetrisShapeTypes;
import shape.ZShape;

public class shapeFactory {
	
	
	
	/*private static Map<Integer, TetrisShape> IShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> JShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> LShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> OShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> SShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> TShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> ZShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, Map<Integer, TetrisShape>> tetrisShapes = new HashMap<Integer, Map<Integer, TetrisShape>>();*/
	private static Map<Integer, TetrisShape> tetrisShapes = new HashMap<Integer,TetrisShape>();
	private static IShape iShape = new IShape();
	private static JShape jShape = new JShape();
	private static LShape lShape = new LShape();
	private static OShape oShape = new OShape();
	private static SShape sShape = new SShape();
	private static TShape tShape = new TShape();
	private static ZShape zShape = new ZShape();

	static {
		
		tetrisShapes.put(TetrisShapeTypes.i, iShape);
		tetrisShapes.put(TetrisShapeTypes.j, jShape);
		tetrisShapes.put(TetrisShapeTypes.l, lShape);
		tetrisShapes.put(TetrisShapeTypes.o, oShape);
		tetrisShapes.put(TetrisShapeTypes.s, sShape);
		tetrisShapes.put(TetrisShapeTypes.t, tShape);
		tetrisShapes.put(TetrisShapeTypes.z, zShape);

	}

	public shapeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static TetrisShape getTetrisShape(int type, int direct) {
		//return tetrisShapes.get(type).get(direct);
		return tetrisShapes.get(type).newInstance(type, direct);
	}
	
	public static TetrisShape getTetrisShape(TetrisShape orgShape) {
		//return tetrisShapes.get(type).get(direct);
		return new TetrisShape(orgShape) {
			
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
	}

}
