import java.util.HashMap;

/**
 * 
 */

/**
 * @author Aditya Sinha
 * 
 * Find length of longest string without repeating characters
 * Take 2 pointers slow and max
 * Use HashMap to store character and latest index
 * If duplicate, jump the slow pointer just past the last occurrence
 * keep updating the length of the longest unique substring found
 * 
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int slow = 0;
		int n = s.length();
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				slow = Math.max(slow, map.get(c) + 1); // jump the slow pointer just past the last occurrence
			}
			map.put(c, i); // store character with latest index
			max = Math.max(max, i - slow + 1);
		}

		return max;
	}
}
