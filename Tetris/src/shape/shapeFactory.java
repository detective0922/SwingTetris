package shape;

import java.util.HashMap;
import java.util.Map;

public class shapeFactory {
	
	
	
	private static Map<Integer, TetrisShape> IShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> JShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> LShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> OShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> SShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> TShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, TetrisShape> ZShapes = new HashMap<Integer, TetrisShape>();
	private static Map<Integer, Map<Integer, TetrisShape>> tetrisShapes = new HashMap<Integer, Map<Integer, TetrisShape>>();
	private static Map<Integer, IShape> testShape = new HashMap<Integer,IShape>();

	static {
		IShapes.put(TetrisShape.POINT_LEFT, new IShape(TetrisShapeTypes.i,
				TetrisShape.POINT_LEFT));
		IShapes.put(TetrisShape.POINT_UP, new IShape(TetrisShapeTypes.i,
				TetrisShape.POINT_UP));
		IShapes.put(TetrisShape.POINT_RIGHT, new IShape(
				TetrisShapeTypes.i, TetrisShape.POINT_RIGHT));
		IShapes.put(TetrisShape.POINT_DOWN, new IShape(TetrisShapeTypes.i,
				TetrisShape.POINT_DOWN));
		
		JShapes.put(TetrisShape.POINT_LEFT, new JShape(TetrisShapeTypes.j,
				TetrisShape.POINT_LEFT));
		JShapes.put(TetrisShape.POINT_UP, new JShape(TetrisShapeTypes.j,
				TetrisShape.POINT_UP));
		JShapes.put(TetrisShape.POINT_RIGHT, new JShape(
				TetrisShapeTypes.j, TetrisShape.POINT_RIGHT));
		JShapes.put(TetrisShape.POINT_DOWN, new JShape(TetrisShapeTypes.j,
				TetrisShape.POINT_DOWN));
		
		LShapes.put(TetrisShape.POINT_LEFT, new LShape(TetrisShapeTypes.l,
				TetrisShape.POINT_LEFT));
		LShapes.put(TetrisShape.POINT_UP, new LShape(TetrisShapeTypes.l,
				TetrisShape.POINT_UP));
		LShapes.put(TetrisShape.POINT_RIGHT, new LShape(
				TetrisShapeTypes.l, TetrisShape.POINT_RIGHT));
		LShapes.put(TetrisShape.POINT_DOWN, new LShape(TetrisShapeTypes.l,
				TetrisShape.POINT_DOWN));
		
		OShapes.put(TetrisShape.POINT_LEFT, new OShape(TetrisShapeTypes.o,
				TetrisShape.POINT_LEFT));
		OShapes.put(TetrisShape.POINT_UP, new OShape(TetrisShapeTypes.o,
				TetrisShape.POINT_UP));
		OShapes.put(TetrisShape.POINT_RIGHT, new OShape(
				TetrisShapeTypes.o, TetrisShape.POINT_RIGHT));
		OShapes.put(TetrisShape.POINT_DOWN, new OShape(TetrisShapeTypes.o,
				TetrisShape.POINT_DOWN));
		
		SShapes.put(TetrisShape.POINT_LEFT, new SShape(TetrisShapeTypes.s,
				TetrisShape.POINT_LEFT));
		SShapes.put(TetrisShape.POINT_UP, new SShape(TetrisShapeTypes.s,
				TetrisShape.POINT_UP));
		SShapes.put(TetrisShape.POINT_RIGHT, new SShape(
				TetrisShapeTypes.s, TetrisShape.POINT_RIGHT));
		SShapes.put(TetrisShape.POINT_DOWN, new SShape(TetrisShapeTypes.s,
				TetrisShape.POINT_DOWN));
		
		TShapes.put(TetrisShape.POINT_LEFT, new TShape(TetrisShapeTypes.t,
				TetrisShape.POINT_LEFT));
		TShapes.put(TetrisShape.POINT_UP, new TShape(TetrisShapeTypes.t,
				TetrisShape.POINT_UP));
		TShapes.put(TetrisShape.POINT_RIGHT, new TShape(
				TetrisShapeTypes.t, TetrisShape.POINT_RIGHT));
		TShapes.put(TetrisShape.POINT_DOWN, new TShape(TetrisShapeTypes.t,
				TetrisShape.POINT_DOWN));
		
		ZShapes.put(TetrisShape.POINT_LEFT, new ZShape(TetrisShapeTypes.z,
				TetrisShape.POINT_LEFT));
		ZShapes.put(TetrisShape.POINT_UP, new ZShape(TetrisShapeTypes.z,
				TetrisShape.POINT_UP));
		ZShapes.put(TetrisShape.POINT_RIGHT, new ZShape(
				TetrisShapeTypes.z, TetrisShape.POINT_RIGHT));
		ZShapes.put(TetrisShape.POINT_DOWN, new ZShape(TetrisShapeTypes.z,
				TetrisShape.POINT_DOWN));
		
		
		tetrisShapes.put(TetrisShapeTypes.i, IShapes);
		tetrisShapes.put(TetrisShapeTypes.j, JShapes);
		tetrisShapes.put(TetrisShapeTypes.l, LShapes);
		tetrisShapes.put(TetrisShapeTypes.o, OShapes);
		tetrisShapes.put(TetrisShapeTypes.s, SShapes);
		tetrisShapes.put(TetrisShapeTypes.t, TShapes);
		tetrisShapes.put(TetrisShapeTypes.z, ZShapes);
		
		testShape.put(TetrisShapeTypes.i, new IShape());

	}

	public shapeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static TetrisShape getTetrisShape(int type, int direct) {
		//return tetrisShapes.get(type).get(direct);
		return testShape.get(type).newInstance(type, direct);
	}

}
