package com.foo.bar.sandbox;

public class MinPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid){
		if(grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		int[][] dist = new int[grid.length][grid[0].length];
		dist[0][0] = grid[0][0];
		for(int x = 1; x < grid.length; ++x){
			dist[x][0] = dist[x-1][0] + grid[x][0];
		}
		for(int y = 1; y < grid[0].length; ++y){
			dist[0][y] = dist[0][y-1] + grid[0][y];
		}
		for(int x = 1; x < grid.length; ++x){
			for(int y = 1; y < grid[0].length; ++y){
				dist[x][y] = Math.min(dist[x - 1][y], dist[x][y-1]) + grid[x][y];
			}
		}
		return dist[grid.length - 1][grid[0].length - 1];
	}
}
