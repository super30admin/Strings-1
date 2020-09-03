import java.util.*;
/**********************************Brute force *********************************/
//Time Complexity : O(n^2), n is length of string
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Longest_Substring_Without_Repeating_Characters_Brute_force {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<s.length(); i++){
			Set<Character> set = new HashSet<>();
			int count = 1;
			set.add(s.charAt(i));
			for(int j= i+1; j<s.length(); j++){
				if(set.contains(s.charAt(j))){
					break;
				}
				else{
					set.add(s.charAt(j));
					count++;

				}
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
/**********************************Sliding Window*********************************/
//Time Complexity : O(n), n is length of string
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Using Sliding window approach, where we store the starting index of every window in the HashMap
 * When the window contains the repeating character, we will update the index of that character
 * max length of such window is the required answer**/

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int slow = 0;
		int fast = 0;
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		while(fast < s.length()){
			char c = s.charAt(fast);
			if(map.containsKey(c)){
				slow = Math.max(slow, map.get(c)+1);    // update slow to the place after index where repeat begins
			}
			map.put(c, fast);   // storing character and its index
			max = Math.max(max, fast-slow+1);    // find max distance as max of previous max and distance between slow and fast
			fast++;
		}
		return max;
	}
}
