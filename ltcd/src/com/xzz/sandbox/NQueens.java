package com.xzz.sandbox;

import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(4));
		System.out.println(new NQueens().totalNQueens(13));
		System.out.println(new NQueens().solveNQueensII(13));
		
	}

	public class QPoint {
		public int x;
		public int y;

		public QPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int totalNQueens(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] q = new int[n];
		for (int i = 0; i < q.length; ++i) {
			q[i] = -1;
		}
		int pos = 0;
		int sol = 0;
		while (pos >= 0) {
			if (pos == n) {
				sol++;
				pos--;// move back
				continue;
			}
			q[pos]++;
			if (q[pos] >= n) {
				q[pos] = -1;
				pos--;
				continue;
			}
			if (isGoodQueen(q, pos)) {
				pos++;
			}
		}
		return sol;
	}

	public boolean isGoodQueen(int[] q, int px) {
		int py = q[px];
		for (int x = 0; x < px; ++x) {
			if (q[x] == py || (Math.abs(x - px) == Math.abs(q[x] - py))) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> solutions = new ArrayList<String[]>();
		ArrayList<QPoint> route = new ArrayList<QPoint>();
		recSolve(route, n, solutions);
		return solutions;
	}

	public int solveNQueensII(int n) {
		ArrayList<QPoint> route = new ArrayList<QPoint>();
		return recSolveII(route, n);
	}

	private void recSolve(ArrayList<QPoint> route, int n,
			ArrayList<String[]> solutions) {
		if (route.size() == n) {
			solutions.add(getSolution(route));
		}
		for (int x = 0; x < n; ++x) {
			QPoint q = new QPoint(x, route.size());
			if (isGoodQueen(route, q)) {
				route.add(q);
				recSolve(route, n, solutions);
				route.remove(route.size() - 1);
			}
		}
	}

	private int recSolveII(ArrayList<QPoint> route, int n) {
		if (route.size() == n) {
			return 1;
		}
		int sol = 0;
		for (int x = 0; x < n; ++x) {
			QPoint q = new QPoint(x, route.size());
			if (isGoodQueen(route, q)) {
				route.add(q);
				sol += recSolveII(route, n);
				route.remove(route.size() - 1);
			}
		}
		return sol;
	}

	private String[] getSolution(ArrayList<QPoint> route) {
		String[] strs = new String[route.size()];
		for (int i = 0; i < route.size(); ++i) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < route.get(i).x; ++x) {
				sb.append('.');
			}
			sb.append('Q');
			for (int x = route.get(i).x + 1; x < route.size(); ++x) {
				sb.append('.');
			}
			strs[i] = sb.toString();
		}
		return strs;
	}

	private boolean isGoodQueen(ArrayList<QPoint> route, QPoint q) {
		for (QPoint qp : route) {
			if (qp.x == q.x || (Math.abs(qp.x - q.x) == Math.abs(qp.y - q.y))) {
				return false;
			}
		}
		return true;
	}
}
