package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_SurroundedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println((new Solution_SurroundedRegions().getClass().getName()));
		// TODO Auto-generated method stub
		char[][] board = new char[][]{
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'},
		};
		printBoard(board);
		(new Solution_SurroundedRegions()).solve(board);
		printBoard(board);
	}
	
	private static void printBoard(char[][] board) {
		int nRow = board.length;
    	if(nRow < 1){
    		return;
    	}
    	int nCol = board[0].length;
    	for(int iRow = 0; iRow < nRow; ++iRow){
    		for(int iCol = 0; iCol < nCol; ++iCol){
    			System.out.print(board[iRow][iCol]);
    		}
    		System.out.println();
    	}
	}

	public class MyPoint{
		public int getiRow() {
			return iRow;
		}
		public void setiRow(int iRow) {
			this.iRow = iRow;
		}
		public int getiCol() {
			return iCol;
		}
		public void setiCol(int iCol) {
			this.iCol = iCol;
		}
		private int iRow;
		private int iCol;
		public MyPoint(int iRow, int iCol){
			this.iRow = iRow;
			this.iCol = iCol;
		}
		public void setVisited(char[][] board, char flag){
			board[iRow][iCol] = flag;
		}
		public boolean onEdge(char[][] board) {
			return iRow >= board.length - 1 || iRow <= 0 || iCol >= board[0].length - 1 || iCol <= 0; 
		}
		public MyPoint[] getNeighbors(char[][] board){
			List<MyPoint> retVal = new ArrayList<MyPoint>(4);
			if(iRow < board.length - 1){
				retVal.add(new MyPoint(iRow + 1, iCol));
			}
			if(iRow > 0){
				retVal.add(new MyPoint(iRow - 1, iCol));
			}
			if(iCol > 0){
				retVal.add(new MyPoint(iRow, iCol - 1));
			}
			if(iCol < board.length - 1){
				retVal.add(new MyPoint(iRow, iCol + 1));
			}
			return retVal.toArray(new MyPoint[0]);
		}
	}

    public void solve(char[][] board) {
    	int nRow = board.length;
    	if(nRow < 1){
    		return;
    	}
    	int nCol = board[0].length;
    	for(int iRow = 0; iRow < nRow; ++iRow){
    		for(int iCol = 0; iCol < nCol; ++iCol){
    			if(board[iRow][iCol] == 'O'){
    				//traverse from here
    				Stack<MyPoint> pts = new Stack<MyPoint>();
    				List<MyPoint> ptList = new ArrayList<MyPoint>();
    				MyPoint root = new MyPoint(iRow, iCol);
    				pts.push(root);
    				ptList.add(root);
    				while(!pts.empty()){
    					MyPoint curPt;
    					(curPt = pts.pop()).setVisited(board, '-');
    					
    					for(MyPoint nb : curPt.getNeighbors(board)){
    						if(board[nb.iRow][nb.iCol] == 'O'){
    							MyPoint nextPt = new MyPoint(nb.iRow, nb.iCol);
    							pts.push(nextPt);
    							ptList.add(nextPt);
    						}
    					}
    				}
    				boolean someOnEdge = false;
    				for(MyPoint p : ptList){
    					if(p.onEdge(board)){
    						someOnEdge = true;
    						break;
    					}
    				}
    				if(!someOnEdge){
    					for(MyPoint p:ptList){
    						p.setVisited(board, 'X');
    					}
    				}
    			}
    		}
    	}
    	for(int iRow = 0; iRow < nRow; ++iRow){
    		for(int iCol = 0; iCol < nCol; ++iCol){
    			if(board[iRow][iCol] == '-'){
    				board[iRow][iCol] = 'O';
    			}
    		}
    	}
    }
}
