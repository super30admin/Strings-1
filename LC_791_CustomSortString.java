// Time Complexity :O(N+26)
// Space Complexity :O(26)
// Did this code successfully run on Leetcode :Yes
//Runtime: Runtime: 0 ms, faster than 100.00% of Java online submissions for Custom Sort String.
//Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Custom Sort String.
// Any problem you faced while coding this : No.

import java.io.*;
import java.util.*;
 

public class LC_791_CustomSortString {
	
	public static String customSort(String S, String T) {
		return sort(S,T);
	}
	
	public static String sort(String ordered, String toOrdered) {
		//The count array keeps occurrence of each characters in toOredred array
		int[] count = new int[26];
		for(int i=0; i < toOrdered.length(); i++) {
			count[toOrdered.charAt(i) - 'a']++;
		}
		StringBuilder sortedArray = new StringBuilder();
		//the below for loop stores the characters in sortedArray in order present in S array 
		for(char c : ordered.toCharArray()) {
			while(count[c -'a'] > 0) {
				sortedArray.append(c);
				count[c -'a']--;
			}
		}
		//The characters presents in T array but not found in S array are appending to the sortedArray
		for(int i=0; i<count.length; i++) {
			while(count[i]>0) {
				sortedArray.append((char)(i + 'a'));
				count[i]--;
			}
			
		}
		return sortedArray.toString();
			
	}
			
	
	 public static void main(String[] args) {
		
		 String S ="cba";
		 String T ="aabcccccd";

		 System.out.println("Custom Sort Order: "+customSort(S,T) );

	 }
}

