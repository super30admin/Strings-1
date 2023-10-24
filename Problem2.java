// Time Complexity : O(n) where n is the size of s
// Space Complexity : O(1) constant space as the size of hashset will always remain constant at max
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int a = 0;
        int b = 0;
        int max = 0;

        while(b < s.length()){
            if(!set.contains(s.charAt(b))){
                set.add(s.charAt(b));
                b++;
                max = Math.max(max, b - a);
            }else{
                set.remove(s.charAt(a));
                a++;
            }
        }

        return max;
    }
}
