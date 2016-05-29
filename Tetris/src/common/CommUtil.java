package common;

import node.TetrisNode;

public class CommUtil {
	
	public static int[][] transposeArray(int[][] intArray) {
		int yLen = intArray.length;
		int xLen = intArray[0].length;
		int[][] newArray = new int[xLen][yLen];
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				newArray[j][i] = intArray[i][j];
			}
		}
		return newArray;
	}


}
