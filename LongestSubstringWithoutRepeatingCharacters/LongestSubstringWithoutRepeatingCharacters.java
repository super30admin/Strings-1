package LongestSubstringWithoutRepeatingCharacters;
import java.util.HashMap;

//Time Complexity	-	O(n) m - number of characters in string s
//Space Complexity	-	O(1) as given in the problem, string s can have maximum 256 diff characters ~ O(256) ~ O(const)

class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0, fast = 0, max = 0;
        
        for(char ch : s.toCharArray()) {
            if(map.containsKey(Character.valueOf(ch)))
                slow = Math.max(slow, map.get(Character.valueOf(ch)));
            map.put(Character.valueOf(ch), fast+1);
            max = Math.max(max, fast-slow+1);
            fast++;
        }
        return max;
    }
}