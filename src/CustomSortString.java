//Time Complexity : O(N + M)
//Space Complexity : O(M)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Put all characters from the string into an array to maintain the count. Then
 * iterate over the order and start appending the count number of times of that
 * character to the string and then make the count to 0 after processing. Now,
 * Iterate over the counts array again to see if any non zero counts are there.
 * If so, then append them to the string and return the string.
 *
 */
class Solution {
	public String customSortString(String order, String s) {
		StringBuilder sb = new StringBuilder();
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		for (char c : order.toCharArray()) {
			if (counts[c - 'a'] > 0) {
				for (int i = 0; i < counts[c - 'a']; i++)
					sb.append(c);
				counts[c - 'a'] = 0;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (counts[i] > 0) {
				for (int j = 0; j < counts[i]; j++)
					sb.append((char) (i + 'a'));
				counts[i] = 0;
			}
		}

		return sb.toString();
	}
}
