package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SurroundedRegion {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public class Point {
        public Point() {

        }

        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        List<Point> area = new ArrayList<Point>();
        Stack<Point> stk = new Stack<Point>();

        for (int y = 1; y < board.length - 1; ++y) {
            for (int x = 1; x < board[0].length - 1; ++x) {

                if (board[x][y] == 'O') {
                    boolean closed = true;
                    area.clear();
                    stk.clear();

                    area.add(new Point(x, y));
                    stk.push(new Point(x, y));

                    while (!stk.isEmpty()) {
                        Point top = stk.pop();
                        board[top.x][top.y] = '-';

                        if (top.x == 0 || top.x == board[0].length - 1
                                || top.y == 0 || top.y == board.length - 1) {
                            closed = false;
                            board[top.x][top.y] = 'O';
                            continue;
                        }
                        int topx_1 = top.x - 1;
                        int topy_1 = top.y - 1;
                        int topxp1 = top.x + 1;
                        int topyp1 = top.y + 1;
                        if (top.x > 0 && board[topx_1][top.y] == 'O') {
                            stk.push(new Point(topx_1, top.y));
                            area.add(stk.peek());
                            board[topx_1][top.y] = '-';
                        }
                        if (top.y > 0 && board[top.x][topy_1] == 'O') {
                            stk.push(new Point(top.x, topy_1));
                            area.add(stk.peek());
                            board[top.x][topy_1] = '-';
                        }
                        if (top.x < board[0].length - 1
                                && board[top.x + 1][top.y] == 'O') {
                            stk.push(new Point(topxp1, top.y));
                            area.add(stk.peek());
                            board[topxp1][top.y] = '-';
                        }
                        if (top.y < board.length - 1
                                && board[top.x][top.y + 1] == 'O') {
                            stk.push(new Point(top.x, topyp1));
                            area.add(stk.peek());
                            board[top.x][topyp1] = '-';
                        }
                    }

                    if (closed) {
                        for (Point p : area) {
                            board[p.x][p.y] = 'X';
                        }
                    }
                }
            }
        }

        for (int y = 1; y < board.length - 1; ++y) {
            for (int x = 1; x < board[0].length - 1; ++x) {
                if (board[x][y] == '-') {
                    board[x][y] = 'O';
                }
            }
        }
    }
}
