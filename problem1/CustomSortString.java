//Time Complexity : O(max(m,n)), m -> Length of order, n -> Length of String 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	/********************* Any order *********************/
	public String customSortStringAnyOrder(String order, String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		int[] cnt = new int[26];
		for (char ch : str.toCharArray()) {
			cnt[ch - 'a']++;
		}

		StringBuilder ans = new StringBuilder();

		for (char ch : order.toCharArray()) {
			for (int i = 0; i < cnt[ch - 'a']; i++) {
				ans.append(ch);
			}
			cnt[ch - 'a'] = 0;
		}

		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < cnt[ch - 'a']; i++) {
				ans.append(ch);
			}
		}

		return ans.toString();
	}

	/***************************************************
	 * Display Elements not in the "order dictionary" in the same order they occur
	 * in the string order
	 ***************************************************/
	public String customSortString(String order, String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		int[] cnt = new int[26];
		Map<Character, Integer> cntMap = new HashMap<Character, Integer>();
		for (char ch : str.toCharArray()) {
			cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
		}

		StringBuilder ans = new StringBuilder();

		for (char ch : order.toCharArray()) {
			if (cntMap.containsKey(ch)) {
				while (cntMap.get(ch) != 0) {
					ans.append(ch);
					cntMap.put(ch, cntMap.get(ch) - 1);
				}
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (cntMap.get(str.charAt(i)) != 0) {
				ans.append(str.charAt(i));
			}
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		CustomSortString obj = new CustomSortString();
		String order = "cba";
		String str = "abcd";
		System.out.println("Custom Sorted String: " + obj.customSortString(order, str));
	}

}
