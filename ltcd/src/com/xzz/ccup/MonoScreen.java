package com.xzz.ccup;

import java.util.Arrays;

import com.xzz.util.BitSet;

public class MonoScreen {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        byte[] screen = new byte[] {0, 0, 0, 0, 0, 0};
        drawLine(screen, 1, 13, 1, 24);
        System.out.println(Arrays.toString(screen));
        for(int i = 0; i < screen.length; ++i){
            if(i % 3 == 0){
                System.out.println();
            }
            System.out.print(BitSet.toString(screen[i]));
            System.out.print(',');
        }
    }
    
    public static void drawLine(byte[] screen, int x1, int x2, int y, int width) {
        int dy = y * (width / 8);
        int dx = x1 / 8;
        int dx_2 = x2 / 8;
        for(int x = dx; x <= dx_2; ++x) {
            screen[x + dy] = (byte)0xFF;
        }
        screen[dy + dx] &= (0xFF >> (x1 % 8));
        screen[dy + dx_2] &= (0xFF << (7 - x2 % 8));
    }
}
