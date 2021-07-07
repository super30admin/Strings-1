package s30Coding;
import java.util.*;

//Time Complexity :- O(n) where n is the length of the string
//Space Complexity :- O(1) since the map would store at most 26 characters.
//LeetCode :- Yes

public class LongestSubStringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0; int slow = 0;
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow +1);
            map.put(c, i+1);
        }
        return max;
    }
}
