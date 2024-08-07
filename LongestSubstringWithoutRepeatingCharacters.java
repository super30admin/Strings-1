// Time Complexity : O(s) - s is length of String
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class LongestSubstringWithoutRepeatingCharacters {
    // Using Hashmap
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(s.isEmpty())
            return 0;
        int slow = 0;
        int maxSubstring = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // slow moves to escape the repeating character
                slow = Math.max(slow, map.get(c) + 1);
            }
            map.put(c, i);
            // print the substring without repeating characters
            int curr = i - slow + 1;
            if(maxSubstring < curr) {
                maxSubstring = curr;
                start = slow;
                end = i;
            }
            //  maxSubstring = Math.max(maxSubstring, (i - slow + 1));
        }
        System.out.print(s.substring(start, end+1));
        return maxSubstring;
    }
}