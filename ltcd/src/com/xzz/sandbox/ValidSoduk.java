package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

public class ValidSoduk {

    public static void main(String[] args){
        String[] strs = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        new ValidSoduk().solveSudoku(strs);
    }
    
    public void solveSudoku(String[] board){
        char[][] b = new char[board.length][];
        for(int ib = 0; ib < b.length; ++ib){
            b[ib] = board[ib].toCharArray();
        }
        solveSudoku(b);
    }
    
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] rowStats = new boolean[9][9]; // [row][val] = taken
        boolean[][] colStats = new boolean[9][9];
        boolean[][][] subStats = new boolean[3][3][9];
        List<Integer> xpos = new ArrayList<Integer>();
        List<Integer> ypos = new ArrayList<Integer>();

        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 9; ++y) {
                if (board[x][y] != '.') {
                    colStats[x][board[x][y] - '1'] = true;
                    rowStats[y][board[x][y] - '1'] = true;
                } else {
                    xpos.add(x);
                    ypos.add(y);
                }
            }
        }
        int[] fillings = new int[xpos.size()];
        for (int i = 0; i < xpos.size(); ++i) {
            fillings[i] = -1;// not filled
        }

        for (int ix = 0; ix < 3; ix++) {
            for (int iy = 0; iy < 3; iy++) {
                for (int x = 0; x < 3; ++x) {
                    for (int y = 0; y < 3; ++y) {
                        int rx = ix * 3 + x;
                        int ry = iy * 3 + y;
                        if (board[rx][ry] != '.') {
                            subStats[ix][iy][board[rx][ry] - '1'] = true;
                        }
                    }
                }
            }
        }

        int pos = 0;
        while (pos >= 0) {
            int lastFill = fillings[pos];
            int curX = xpos.get(pos);
            int curY = ypos.get(pos);
            int subX = curX / 3;
            int subY = curY / 3;

            fillings[pos]++;

            while (fillings[pos] < 9 && (colStats[curX][fillings[pos]] || rowStats[curY][fillings[pos]] || subStats[subX][subY][fillings[pos]])) {
                fillings[pos]++;
            }
            if (fillings[pos] == 9) {
                if(lastFill >= 0){
                    rowStats[curY][lastFill] = false;
                    colStats[curX][lastFill] = false;
                    subStats[subX][subY][lastFill] = false;
                }
                
                fillings[pos--] = -1;
                continue;
            }
            //System.out.println(curX);
            // all not filled
            if (pos == xpos.size() - 1) {
                // done!
                for(int i = 0; i < xpos.size(); ++i){
                    board[xpos.get(i)][ypos.get(i)] = (char)('1' + fillings[i]);
                }
                return;
            } else {
                if(lastFill >= 0){
                    rowStats[curY][lastFill] = false;
                    colStats[curX][lastFill] = false;
                    subStats[subX][subY][lastFill] = false;
                }
                
                rowStats[curY][fillings[pos]] = true;
                colStats[curX][fillings[pos]] = true;
                subStats[subX][subY][fillings[pos]] = true;
                pos++;
                continue;
            }
        }
    }

    private List<Character> findCandidates(char[][] board, int x, int y) {
        List<Character> retVal = new ArrayList<Character>();
        boolean[] flags = new boolean[9];
        for (int ix = 0; ix < 9; ++ix) {
            if (board[ix][y] != '.') {
                flags[board[ix][y] - '1'] = true;
            }
        }
        for (int iy = 0; iy < 9; ++iy) {
            if (board[x][iy] != '.') {
                flags[board[x][iy] - '1'] = true;
            }
        }
        int cx = (x / 3) * 3;
        int cy = (y / 3) * 3;
        for (int ix = 0; ix < 3; ++ix) {
            for (int iy = 0; iy < 3; ++iy) {
                if (board[cx + ix][cy + iy] != '.') {
                    flags[board[cx + ix][cy + iy] - '1'] = true;
                }
            }
        }
        for (int i = 0; i < 9; ++i) {
            if (!flags[i]) {
                retVal.add((char) (i + '1'));
            }
        }
        return retVal;
    }

    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        for (int x = 0; x < 9; ++x) {
            boolean[] flags = new boolean[9];
            for (int y = 0; y < 9; ++y) {
                if (board[x][y] == '.') {
                    continue;
                }
                if (board[x][y] < '1' || board[x][y] > '9') {
                    return false;
                }
                if (flags[board[x][y] - '1']) {
                    return false;
                }
                flags[board[x][y] - '1'] = true;
            }
        }
        for (int y = 0; y < 9; ++y) {
            boolean[] flags = new boolean[9];
            for (int x = 0; x < 9; ++x) {
                if (board[x][y] == '.') {
                    continue;
                }
                if (board[x][y] < '1' || board[x][y] > '9') {
                    return false;
                }
                if (flags[board[x][y] - '1']) {
                    return false;
                }
                flags[board[x][y] - '1'] = true;
            }
        }
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                boolean[] flags = new boolean[9];
                for (int ix = 0; ix < 3; ++ix) {
                    for (int iy = 0; iy < 3; ++iy) {
                        int rx = ix + x * 3;
                        int ry = iy + y * 3;

                        if (board[rx][ry] == '.') {
                            continue;
                        }
                        if (board[rx][ry] > '9' || board[rx][ry] < '1' || flags[board[rx][ry] - '1']) {
                            return false;
                        }
                        flags[board[rx][ry] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
