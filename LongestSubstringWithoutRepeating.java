// Time Complexity : O(2n) ~ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int longestLength = 0;
        int slow = 0;
        for(int i=0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                while(s.charAt(slow) != s.charAt(i)) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(s.charAt(i));
            longestLength = Math.max(longestLength, i-slow+1);
        }
        return longestLength;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longestLength = 0;
        int slow = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                slow = Math.max(slow, map.get(s.charAt(i))+1);
                
            }
            map.put(s.charAt(i), i);
            longestLength = Math.max(longestLength, i-slow+1);
        }
        return longestLength;
        
    }
}