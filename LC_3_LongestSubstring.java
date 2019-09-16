
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
//Runtime: Runtime: 10 ms, faster than 43.41% of Java online submissions for Longest Substring Without Repeating Characters.
//Memory Usage: 37.1 MB, less than 99.29% of Java online submissions for Longest Substring Without Repeating Characters.
import java.io.*;
import java.util.*;
public class LC_3_LongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int count=0, j=0, i=0;
        while(i < len && j < len ){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                count = Math.max(count, i-j);   
            }else{
                set.remove(s.charAt(j++));
            }
        }
        return count;
    }
	 public static void main(String[] args) {
		 String str ="aabcccccd";
		 System.out.println("Length of longest substring without repeating characters: "+lengthOfLongestSubstring(str) );

	 }

}
