package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xzz.util.Timing;

public class WordLadderII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.addAll(Arrays.asList( "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
		System.out.println(new WordLadderII().findLadders("cet", "ism", set).toString());
		
		//set.addAll(Arrays.asList( "hot", "dot", "dog", "lot", "log"));
		//System.out.println(new WordLadderII().findLadders("hit", "cog", set).toString());
	}

	private Timing tmg = new Timing();
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	tmg.reset();
    	Map<String, Set<String>> map = new HashMap<String, Set<String>>();
    	List<String> words = new ArrayList<String>();
    	words.addAll(Arrays.asList(dict.toArray(new String[0])));
    	if(!words.contains(start)){
    		words.add(start);
    	}
    	if(!words.contains(end)){
    		words.add(end);
    	}
    	for(String s: words){
    		map.put(s, new HashSet<String>());
    	}
    	for(String s : words){
    		//map.put(s, new HashSet<String>());
    		for(String s2 : words){
    			if(!s.equals(s2) && isNeighbor(s, s2)){
    				map.get(s).add(s2);
    				map.get(s2).add(s);
    			}
    		}
    	}
    	tmg.check("cache");
    	
    	ArrayList<ArrayList<String>> retVal = new ArrayList<ArrayList<String>>();
    	HashSet<String> prev = new HashSet<String>();
    	List<String> q = new ArrayList<String>();
    	HashMap<String, Integer> distMap = new HashMap<String, Integer>();
    	q.add(start);
    	prev.add(start);
    	int mindist = 0;
    	while(q.size() > 0){
    		List<String> tmp = new ArrayList<String>(q.size());
    		mindist++;
    		boolean found = false;
    		for(String qItem : q){
    			distMap.put(qItem, mindist);
    			if(qItem.equals(end)){
    				found = true;
    				//break;
    			}
    			for(String nb : map.get(qItem)){
    				if(!prev.contains(nb)){//not yet visited
    					tmp.add(nb);
    					prev.add(nb);
    				}
    			}
    		}
    		if(found){
    			break;
    		}
    		q = tmp;
    	}
    	tmg.check("route");
    	
    	recFindString(start, end, map, mindist, retVal, distMap, new ArrayList<String>(), new HashSet<String>(), new HashSet<String>());
    	tmg.check("recFind");
    	
    	return retVal;
    }


	private void recFindString(String current, String end,
		 Map<String, Set<String>> map,
			int mindist, ArrayList<ArrayList<String>> retVal,
			HashMap<String, Integer> distMap, ArrayList<String> route, HashSet<String> visited, HashSet<String> blackList) {
		route.add(current);
		visited.add(current);
		if(route.size() == mindist){
			if(current.equals(end)){
				ArrayList<String> copy = new ArrayList<String>();
				copy.addAll(Arrays.asList(route.toArray(new String[0])));
				retVal.add(copy);
			}else{
				//give up this route, marking all the 
			}
		}else{
			for(String nb : map.get(current)){
				if(!visited.contains(nb) && distMap.containsKey(nb) && distMap.get(nb) + 1 >= route.size()){
					recFindString(nb, end, map, mindist, retVal, distMap, route, visited, blackList);
				}
			}
		}
		route.remove(route.size() - 1);
		visited.remove(current);
	}


	private boolean isNeighbor(String s, String s2) {
		if(s.length() != s2.length()){
			return false;
		}
		if(s.equals(s2)){
			return false;
		}
		char[] sch = s.toCharArray();
		char[] sch2 = s2.toCharArray();
		int misMatch = 0;
		for(int i = 0; i < sch.length; ++i){
			if(sch[i] != sch2[i]){
				if(++misMatch > 1){
					return false;
				}
			}
		}
		return misMatch == 1;
	}
}
