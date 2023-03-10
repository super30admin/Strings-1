import java.util.HashMap;
import java.util.Map;
//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a map and put each char and its next index.
 * Iterate over the entire string and check if that char
 * is already present in the map. If so, get the next index
 * of that char. we have to make sure that index is ahead of
 * the earlier index we checked. So maintain a variable to 
 * keep track of left index. Subtract left from right to get
 * the length of substring and put it in max. return max.
 *
 */
class Solution {
	public int lengthOfLongestSubstring(String s) {
		// Deque<Character> queue = new LinkedList<>();
		// int max = Integer.MIN_VALUE;
		// for(int i=0;i<s.length();i++) {
		// char c = s.charAt(i);
		// if(queue.contains(c)) {
		// max = Math.max(max, queue.size());
		// while(queue.contains(c))
		// queue.removeFirst();
		// queue.addLast(c);
		// } else {
		// queue.addLast(c);
		// }
		// }
		// return Math.max(max, queue.size());
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				i = Math.max(i, map.get(c));
			}
			max = Math.max(max, j - i + 1);
			map.put(c, j + 1);
		}
		return max;
	}
}