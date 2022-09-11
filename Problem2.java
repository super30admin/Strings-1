// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                System.out.println(slow + " " + map.get(c));
                slow = Math.max(slow, map.get(c));
            }
            maxLength = Math.max(maxLength, i - slow + 1);
            map.put(c, i + 1);
        }
        
        return maxLength;
        
        // Set Solution
        // Set<Character> set = new HashSet<>();
        // int slow = 0;
        // int max = 0;
        // for(int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if(set.contains(c)) {
        //         while(s.charAt(slow) != c) {
        //             set.remove(s.charAt(slow));
        //             slow++;
        //         }
        //          set.remove(s.charAt(slow));
        //             slow++;
        //     }
        //     max = Math.max(max, i - slow + 1);
        //     set.add(c);
        // }
        // return max;
    }
}