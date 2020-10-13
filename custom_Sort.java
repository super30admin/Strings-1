// TC: O(M+N) where M is length of T array and N is length of S array
// SC: O(1) upper bound for 26 characters

import java.util.*;
public class custom_Sort {

	public String CustomSort(String S, String T) {
		
		// Base case
		if(S == null || S.length() == 0 || T == null)
			return "";
		HashMap<Character, Integer> map = new HashMap<>();
		
		// Store the T characters and its count in the map
		for(char c: T.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		// iterate over S String
		for(char c: S.toCharArray()) {
			cnt = 0;
			// if the character is present in map, get the characters count
			if(map.containsKey(c)) {
				cnt = map.get(c);  
			}
			// loop over till count times and add character for count times
			for(int i=0;i<cnt;i++) {
				sb.append(c);
			}
			// once we have processed that character, remove it from map
			map.remove(c);
		}
		
		for(char c: map.keySet()) {
			// retain the remaining characters in map and take its count and add it to our result string
			cnt = map.get(c);
			for(int i=0;i<cnt;i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		custom_Sort cs = new custom_Sort();
		System.out.println(cs.CustomSort("cba", "abcd"));
	}
}
