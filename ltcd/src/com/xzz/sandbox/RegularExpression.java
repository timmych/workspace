package com.xzz.sandbox;

public class RegularExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RegularExpression().isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"	));
		System.out.println(new RegularExpression().isMatchDP("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"	));
		
		System.out.println(new RegularExpression().isMatch("", "c*.*"	));
		System.out.println(new RegularExpression().isMatchDP("", "c*.*"	));
	}
	
	public boolean isMatchDP(String s, String p){
		boolean[][] matrix = new boolean[s.length() + 1][p.length() + 1];
		matrix[s.length()][p.length()] = true;
		for(int is = s.length(); is >= 0; --is){
			for(int ip = p.length() - 1; ip >= 0; --ip){
				if(p.charAt(ip) == '*'){
					matrix[is][ip] = false;
					continue;
				}
				boolean dot = p.charAt(ip) == '.';
				boolean star = ip < p.length() - 1 && p.charAt(ip + 1) == '*';
				boolean isEnd = is == s.length();
				if(star){
					if(dot || (!isEnd && p.charAt(ip) == s.charAt(is))){
						matrix[is][ip] = matrix[is][ip + 2] //dont match this char in s
										|| (!isEnd && matrix[is + 1][ip]) // match this one , but still use the * pattern
										|| (!isEnd && matrix[is + 1][ip + 2]); //match this one, and move to next pattern
					}else{
						matrix[is][ip] = matrix[is][ip + 2];
					}
				}else{
					if(!isEnd && (dot || p.charAt(ip) == s.charAt(is))){
						matrix[is][ip] = matrix[is + 1][ip + 1];
					}else{
						matrix[is][ip] = false;
					}
				}
			}
		}
		return matrix[0][0];
	}

	public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Character lastStar = null;
        StringBuilder np = new StringBuilder();
        for(int i = 0;  i < p.length(); ++i){
            
            if(lastStar == null){
                if(i < p.length() - 1 && p.charAt(i+1) == '*'){
                    lastStar = p.charAt(i);
                    np.append(p.charAt(i));
                    np.append(p.charAt(++i));
                    continue;
                }                
            }else{
                if(((char)lastStar == p.charAt(i) || lastStar == '.' 
                || p.charAt(i) == '.') 
                    && i < p.length() - 1 && p.charAt(i+1) == '*'){
                    lastStar = p.charAt(i);
                    if(p.charAt(i) == '.'){
                        np.setCharAt(np.length() - 2, '.');
                    }
                    ++i;
                    continue;
                }
                if( i == p.length() - 1 || p.charAt(i+1) != '*'){
                    lastStar = null;
                }
            }
            np.append(p.charAt(i));
        }
        return recMatch(s, 0, np.toString(), 0);
    }
    
    public boolean recMatch(String s, int is, String p, int ip){
        if(is == s.length()){
            if(ip == p.length()){
                return true;
            }
            if(ip < p.length() - 1 && p.charAt(ip + 1) == '*'){
                return recMatch(s, is, p, ip + 2);
            }
            return false;
        }
        if(ip == p.length()){
            return false;
        }
        boolean star = ip < p.length() - 1 && p.charAt(ip + 1) == '*';
        boolean dot = p.charAt(ip) == '.';
        if(dot){
            if(star){
                return recMatch(s, is, p, ip + 2)
                || recMatch(s, is + 1, p, ip + 2) 
                || recMatch(s, is + 1 , p, ip);
            }else{
                return recMatch(s, is + 1, p, ip + 1);
            }
        }else{
            if(star){
                if(p.charAt(ip) != s.charAt(is)){
                    return recMatch(s, is, p, ip + 2);
                }else{
                    return recMatch(s, is, p, ip + 2) 
                    || recMatch(s, is + 1, p , ip + 2) 
                    || recMatch(s, is + 1, p , ip);
                }
            }else{
                if(p.charAt(ip) != s.charAt(is)){
                    return false;
                }
                return recMatch(s, is + 1, p , ip+1);
            }
        }
    }
}
