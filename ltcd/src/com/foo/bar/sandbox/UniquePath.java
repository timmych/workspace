//package com.foo.bar.sandbox;
//
//public class UniquePath {
//	
//    
//	
//    public int uniquePaths(int m, int n) {
//        
//        m--;
//        n--;
//        
//        if(m == 0 || n == 0){
//            return 1;
//        }
//        if(m > n){
//            int tmp = m;
//            m = n;
//            n = tmp;
//        }
//        // C(m, m+n)
//        long retval = 1;
//        int nn = 2;
//        
//        for(int mm = m + n; mm > n; --mm){
//            retval *= mm;
//            
//            while(nn <= m && retval > nn && retval % nn == 0){
//                retval /= nn;
//                nn++;
//            }
//        }
//        
//        return (int)retval;        
//    }
//}