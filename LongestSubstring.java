//Time Complexity: O(n) where n is length of String.
//Space Complexity: O(n) Worst case length of string in map no repeat characters
import java.util.HashMap;

public class LongestSubstring {
	    public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0) return 0;
	        int slow = 0, fast = 0, max = 0;
	        HashMap<Character, Integer> map = new HashMap<>();
	        while(fast < s.length()){
	            Character c = s.charAt(fast);
	            if(map.containsKey(c)){
	                slow = Math.max(slow, map.get(c));
	            }
	            map.put(c, fast + 1);
	            max = Math.max(max, fast - slow + 1);
	            fast++;
	        }
	        return max;
	    }
}
