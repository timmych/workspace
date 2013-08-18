package com.foo.bar.sandbox;

import java.util.ArrayList;
import java.util.List;

public class PrintQCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printQuestionCombinations("adg?b?dd?g");
		System.out.println(BinaryOutput("adg?b?dd?g"));
	}
	public static List<String> BinaryOutput(String input) {

		  if (input == null || input.isEmpty())
		    return null;

		  List<String> output = new ArrayList<String>();
		  List<String> temp = new ArrayList<String>();
		  temp.add("");
		  
		  for (int i = 0; i < input.length(); i++) {
		    output.clear();
		    for (String s : temp) {    
		      if (input.charAt(i) == '?') {
		        output.add(s + '0');
		        output.add(s + '1');
		      }
		      else {
		        output.add(s + input.charAt(i));
		      }
		    }
		    temp = new ArrayList<String>(output);
		  }

		  return output;
		} 

	private static void printQuestionCombinations(String string) {
		List<Integer> positions = new ArrayList<Integer>();
		List<Integer> values = new ArrayList<Integer>();
		for(int i = 0; i < string.length(); ++i){
			if(string.charAt(i) == '?'){
				positions.add(i);
				values.add(-1);
			}
		}
		int pos = 0;
		while(pos >= 0){
			int val = values.get(pos) + 1;
			if(val == 2){
				values.set(pos--, -1);//reset current and move back 1 position
				continue;
			}
			values.set(pos, val);
			if(pos == values.size() - 1){
				char[] comb = string.toCharArray();
				for(int ip = 0; ip < positions.size(); ++ip){
					comb[positions.get(ip)] = (char)('0' + values.get(ip));
				}
				System.out.println(comb);
			}else{
				pos++;
			}
		}
	}

}
