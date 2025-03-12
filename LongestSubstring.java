// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(1) as the hashmap will have at most 26 characters
import java.util.HashMap;
import java.util.Map;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int p1 = 0, p2 = 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        while(p1 < s.length() && p2 < s.length()){
            if(map.containsKey(s.charAt(p2))){
                p1 = Math.max(map.get(s.charAt(p2))+1, p1);

            }
            map.put(s.charAt(p2), p2);
            int len = p2-p1+1;
            count = Math.max(len, count);
            p2++;
        }
        return count;
    }
}
