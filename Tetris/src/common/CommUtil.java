package common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import node.TetrisNode;

public class CommUtil {
	
	public static int[][] transposeArray(int[][] intArray) {
		int yLen = intArray.length;
		int xLen = intArray[0].length;
		int[][] newArray = new int[xLen][yLen];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < xLen; i++) {
			for (int j = 0; j < yLen; j++) {
				//newArray[i][j]=intArray[xLen-j-1][i];  
				queue.offer(intArray[j][i]);
			}
		}
		for (int i = xLen - 1; i >= 0; i--) {
			for (int j = 0; j < yLen; j++) {
				newArray[i][j] = queue.poll();
			}
		}
		
		return newArray;

	}
	
}
