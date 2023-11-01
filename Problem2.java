
//T.C : O(n) where n is the size of the s string
//S.C : O(1) assuming there will be 26 alphabets in the hashmap
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
import java.util.HashMap;

public class Problem2 {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start,map.get(c));
            }
            max = Math.max(max, i-start+1);
            map.put(c,i+1);
        }

        return max;
    }
}