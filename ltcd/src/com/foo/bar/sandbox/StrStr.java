package com.foo.bar.sandbox;

public class StrStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println((new StrStr()).strStr0("babba", "bbb"));
		
		//System.out.println((new StrStr()).divide(-2147483648, 1));
	}

   
	public String strStr0(String haystack, String needle){
		for(int i = 0; i <= haystack.length() - needle.length(); ++i){
			boolean matched = true;
			for(int k = 0; k < needle.length(); ++k){
				if(haystack.charAt(i + k) != needle.charAt(k)){
					matched = false;
					break;
				}
			}
			if(matched){
				return haystack.substring(i);
			}
		}
		return null;
	}

	
	public String strStr(String haystack, String needle){
		String source = haystack;
		String target = needle;
		
		if(target.length() == 0){
			return haystack;
		}
		
		int[] fallback = new int[target.length()];
		
		fallback[0] = -1;
		
		if(target.length() > 1){
			fallback[1] = 0;
			
			int cnt = 0;
			int i = 2;
			while(i < target.length()){
				if(target.charAt(i - 1) == target.charAt(cnt)){
					fallback[i] = ++cnt;
					++i;
				}else if(cnt > 0){
					cnt = fallback[cnt];
				}else{
					cnt = 0;
					fallback[i++] = 0;
				}
			}
		}
		int sPos = 0;
		int len = 0;
		
		while(sPos + len < source.length()){
			if(source.charAt(sPos + len) == target.charAt(len)){
				if(++len == target.length()){
					return source.substring(sPos);
				}
			}else{
				int fb = fallback[len];
				sPos = sPos + len - fb;
				len = fb;
				if(fb < 0){
					len = 0;
				}else{
					len = fb;
				}
			}
		}
		return null;
	}
}
