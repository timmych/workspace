package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordSearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] board = new char[][]{
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'},
        };
        System.out.println(new WordSearch().exist(board, "adfcsc"));
    }
    
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        if(board.length == 0){
            return false;
        }
        int dx = board.length;
        int dy = board[0].length;
        
        Stack<Integer> stackX = new Stack<Integer>();
        Stack<Integer> stackY = new Stack<Integer>();
        Stack<Integer> stackDir = new Stack<Integer>();
        for(int x = 0; x < dx ;++x){
            for(int y = 0; y < dy; ++y){
                if(board[x][y] == word.charAt(0)){
                    int pos = 1;
                    stackX.add(x);
                    stackY.add(y);
                    stackDir.add(-1);
                    board[x][y] = '.';
                    while(pos > 0 && pos < word.length()){
                        int curX = stackX.peek();
                        int curY = stackY.peek();
                        int dir = stackDir.pop() + 1;
                        stackDir.push(dir);
                        if(dir > 3){
                            board[curX][curY] = word.charAt(--pos);
                            stackX.pop();
                            stackY.pop();
                            stackDir.pop();
//                            if(stackDir.size() > 0){
//                                stackDir.push(stackDir.pop() + 1);
//                            }
                        }else{
                            switch(dir){
                            case 0: curY++; break;
                            case 1: curX++; break;
                            case 2: curY--; break;
                            case 3: curX--; break;
                            }
                            if(curX >= 0 && curX < dx && curY >= 0 && curY < dy && board[curX][curY] == word.charAt(pos)){
                                board[curX][curY] = '.';
                                stackX.push(curX);
                                stackY.push(curY);
                                stackDir.push(-1);
                                pos++;
//                            }else{
//                                stackDir.pop();
//                                stackDir.push(dir + 1);
                            }
                        }
                    }
                    if(pos == word.length()){
                        return true;
                    }
                    board[x][y] = word.charAt(0);
                }
            }
        }
        
        return false;
    }
    

    public boolean existRec(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        if(board.length == 0){
            return false;
        }
        
        int dx = board.length;
        int dy = board[0].length;
        
        for(int x = 0; x < dx; ++x){
            for(int y = 0; y < dy; ++y){
                char tmp = board[x][y];
                
                if(board[x][y] == word.charAt(0)){
                    board[x][y] = 'x';
                    if(reallyExists(board, word, x, y, 1)){
                        return true;
                    }
                }
                board[x][y] = tmp;
            }
        }
        return false;
    }

    private boolean reallyExists(char[][] board, String word, int x, int y, int iw) {
        if(iw == word.length()){
            return true;
        }
        
        List<Integer> ax = new ArrayList<Integer>();
        List<Integer> ay = new ArrayList<Integer>();
        
        if(x > 0){
            ax.add(x - 1);
            ay.add(y);
        }
        if(x < board.length - 1){
            ax.add(x + 1);
            ay.add(y);
        }
        if(y > 0){
            ax.add(x);
            ay.add(y - 1);
        }
        if(y < board[0].length - 1){
            ax.add(x);
            ay.add(y + 1);
        }
        
        for(int i = 0; i < ax.size(); ++i){
            int nx = ax.get(i);
            int ny = ay.get(i);
            if(board[nx][ny] == word.charAt(iw)){
                char tmp = board[nx][ny];
                board[nx][ny] = 'x';
                if(reallyExists(board, word, nx, ny, iw + 1)){
                    return true;
                }
                board[nx][ny] = tmp;
            }        
        }
        return false;
    }
}