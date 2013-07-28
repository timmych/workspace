package com.xzz.sandbox;


public class MultiplyStrings {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MultiplyStrings().multiply("100001000010000100001000010000", "1999999990"));
    }

    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length() + 2];
        for(int i = 0; i < num1.length() + num2.length() + 2; ++i){
            result[i] = 0;
        }
        int[] val1 = new int[num1.length()];
        int[] val2 = new int[num2.length()];
        for(int i = 0; i < num1.length(); ++i){
            val1[num1.length() - i - 1] = num1.charAt(i) - '0';
        }
        for(int i = 0; i < num2.length(); ++i){
            val2[num2.length() - i - 1] = num2.charAt(i) - '0';
        }
        for(int i2 = 0; i2 < num2.length(); ++i2){
            for(int i1 = 0;i1 < num1.length(); ++i1){
                int mul = val2[i2] * val1[i1];
                result[i1 + i2] += mul;
                for(int k = i1+i2; ;++k){
                    int tmp = result[k];
                    result[k] = tmp % 10;
                    result[k + 1] += tmp / 10;
                    if(tmp / 10 == 0){
                        break;
                    }
                }
            }
        }
        
        int trimming = 0;
        for(int i = result.length - 1; i >=0 ; --i){
            if(result[i] == 0){
                trimming++;
            }else{
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = result.length - 1 - trimming; i >= 0 ; --i){
            sb.append(result[i]);
        }
        String ret = sb.toString();
        return ret.length() > 0 ? ret : "0";
    }
}
