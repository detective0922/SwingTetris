package common;

import node.TetrisNode;

public class CommUtil {
	
	public static void transposeArray(TetrisNode[][] intArray) {
		int yLen = intArray.length;
		int xLen = intArray[0].length;
		TetrisNode[][] newArray = new TetrisNode[xLen][yLen];
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				newArray[j][i] = intArray[i][j];
			}
		}
		intArray = newArray;
	}


}
