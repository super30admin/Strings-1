//Time Complexity : O(n)
//Space Complexity : O(1)
/*Approach
-mapping each character to its index
-taking slow and fast pointer, slow will move only when duplicate occurs ,to max of slow or next of 
character where it previously occurred
-fast will keep moving one at a time 
-max will store maximum gap of slow and fast which is length of maximum substring with no repeating 
characters
 */
import java.util.HashMap;

public class LongestSubstringWIthNonRepeating{
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0; int fast = 0;
        int start = 0; int end = 0;
        int max = 0;
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            map.put(c, fast+1);
            if(max < (fast-slow+1)){
                start = slow;
                end = fast;
                max = fast-slow+1;
            }
            fast++;
        }
        System.out.println(s.substring(start, end+1));
        return max;
    }
    public static void main(String args[]) {
        LongestSubstringWIthNonRepeating obj = new LongestSubstringWIthNonRepeating();
        System.out.println(obj.lengthOfLongestSubstring("znbnycacbpy"));
    }
}