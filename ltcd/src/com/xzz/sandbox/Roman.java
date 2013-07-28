/**
 * 
 */
package com.xzz.sandbox;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaozhec
 *
 */
public class Roman {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Roman().romanToInt("CML"));
        System.out.println(new Roman().intToRoman(950));
    }
    
    public int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < chs.length; ++i) {
            int curVal = RomanDigit.DIGITS.get(chs[i]).val;
            if(i < chs.length - 1 && curVal < RomanDigit.DIGITS.get(chs[i + 1]).val){
                sum += (RomanDigit.DIGITS.get(chs[i + 1]).val - curVal);
                ++i;
            }else{
                sum += curVal;
            }
        }
        return sum;
    }
    
    
    public String intToRoman(int num) {
        char[] tens = new char[] { 'M', 'C', 'X', 'I'};
        char[] fives = new char[] { 'M', 'D', 'L', 'V'};
        int rem = num;
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        while(rem > 0) {
            int base = (int) Math.pow(10, tens.length - cur - 1);
            int div = rem / base;
            rem = rem % base;
            
            if(div < 4){
                for(int i = 0; i < div; ++i){
                    sb.append(tens[cur]);
                }
            }else if(div == 4){
                sb.append(tens[cur]);
                sb.append(fives[cur]);
            }else if(div < 9){
                sb.append(fives[cur]);
                for(int i = 0; i < div - 5; ++i){
                    sb.append(tens[cur]);
                }
            }else{//==9
                sb.append(tens[cur]);
                sb.append(tens[cur - 1]);
            }
            cur++;
        }
        return sb.toString();
    }

    
    public enum RomanDigit {
        
        I(1, 'I'),
        V(5, 'V'),
        X(10, 'X'),
        L(50, 'L'),
        C(100, 'C'),
        D(500, 'D'),
        M(1000, 'M')
        ;
        public int val;
        public char ch;
        public static final Map<Character, RomanDigit> DIGITS;
        
        static{
            DIGITS = new HashMap<Character, RomanDigit>();
            for(RomanDigit rd : RomanDigit.values()){
                DIGITS.put(rd.ch, rd);
            }
        }
        
        RomanDigit(int val, char ch) {
            this.val = val;
            this.ch = ch;
        }
    }
}
