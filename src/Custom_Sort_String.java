//Time Complexity : O(m+n),length of 2 strings
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Store all the characters of the T string to a HashMap with their frequency
 * For each character in S, append all the characters occurrences to the String Builder 
 * Remove the keys, once the count hits zero. At the end for any remaining entries in the HashMap, append it to the string Builder and return the String**/

import java.util.*;
public class Custom_Sort_String {
	public String customSortString(String S, String T) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<T.length(); i++){
			char c = T.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(int i=0; i<S.length(); i++){
			char c = S.charAt(i);
			if(map.containsKey(c)){
				int count = map.get(c);
				while(count > 0){
					sb.append(c);
					count--;
				}
				map.remove(c);
			}
		}
		for(char key: map.keySet()){
			int count = map.get(key);
			while(count > 0){
				sb.append(key);
				count--;
			}
		}
		return sb.toString();
	}
}
