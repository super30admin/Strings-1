// Time Complexity : O(n) where n is the length of the string s
// Space Complexity :O(1) since the HashSet will have a fixed number of elements at max = 26
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this
import java.util.HashSet;
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0, count =0;

        while(left < s.length() && right < s.length()){

            Character c = s.charAt(right);
            if(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
                count--;

            }else{
                set.add(c);
                count++;
                right++;
            }

            max = Math.max(count, max);
        }
        return max;
    }
}
