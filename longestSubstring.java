// TC: O(n) where n is the length of the string
// SC: O(N) where n is number of characters stored in HashMap, O(1) for 26 character upper bound if only alphabet characters in String

import java.util.*;

public class longestSubstring {

	public int lengthlongestSubstring(String s) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		int res = 0;
		int st = 0, end = 0;
		
		while(st< s.length() && end < s.length()) {
			if(map.containsKey(s.charAt(end))) {  // check if the character is present in the String, if its already present, update the starting point
				// since we don't consider repeating characters, 
				st = Math.max(st,  map.get(s.charAt(end))); 
			}
			res = Math.max(end-st+1, res); // keep calculating the result length for the maximum window size between start and end
			// push our characters onto map with the index+1 because while moving our start pointer, we need to move 1 step ahead of repeating character
			// so we need +1 so that start pointer moves one point ahead of repeated character since we should not consider repeated character
			map.put(s.charAt(end), end+1);
			end++;
		}
		return res;
	}
}
