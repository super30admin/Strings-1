// Time Complexity: O(n) length of entire string
// Space Complexity: O(n) -> O(1) since only 26 chars
public class LongestSubstringWORepeatChar {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s == null || s.length() == 0)
            return max;
        
        // stores the index of repeating char
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;        
        for(int fast = 0 ; fast < s.length() ; fast++)
        {
            char c = s.charAt(fast);
            if(map.containsKey(c)) // char is repeated
            {
                // get loc of curr slow or index to start slow from
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, fast - slow + 1); // cal max substring everytime
            map.put(c, fast+1); // +1 since we need to move slow to next elocation of next substring
        }
        
        return max;
    }
}
