// Time Complexity : O(n), n is length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create two pointers to denote the start and end of the substring. Initially begin with the smallest substring of length 2, and add those characters to a HashMap, while checking if the character is repeated and finally finding the largest substring, by adjusting the start and end pointers.

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxLength = 1;
        
        int start = 0;
        int end = 1;

        map.put(s.charAt(start), start);
        while(end < s.length()){        
            // Check if char at end is present in HashMap

            // If present in HashMap, also check if value index in HashMap for that character is greater than equal to start
            // Test case: "tmmzuxt"
            if(map.get(s.charAt(end)) != null && map.get(s.charAt(end)) >= start){
                // Reset the start pointer to end index + 1
                start = map.get(s.charAt(end)) + 1;
                map.put(s.charAt(end), end);
            } else {
                // If char is not present in HashMap, add the character and its corresponding index
                map.put(s.charAt(end), end);
                maxLength = Math.max(maxLength, end - start + 1); 
            }
            end = end + 1;
        }
        
        return maxLength;
    }
}
