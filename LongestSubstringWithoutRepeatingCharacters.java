// Time Complexity : O(n) where n = length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//3. Longest Substring Without Repeating Characters (Medium) - https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
//    	HashSet<Character> set = new HashSet<>(); // O(1)
//        int start = 0, max = 0;
//        
//        for (int i = 0; i < s.length(); i++) { // O(n)
//            char ch = s.charAt(i);
//            
//            if (set.contains(ch)) { // O(1)
//                while (s.charAt(start) != ch) {
//                    set.remove(s.charAt(start));
//                    start++;
//                }
//                //set.remove(s.charAt(start));
//                start++;
//            }
//            
//            max = Math.max(max, i - start + 1);
//            set.add(ch);
//        }
//        
//        return max;
        
        HashMap<Character, Integer> map = new HashMap<>(); // O(1)
        int start = 0, max = 0;
        
        for (int i = 0; i < s.length(); i++) { // O(n)
            char ch = s.charAt(i);
            
            if (map.containsKey(ch)) { // O(1)
                start = Math.max(start, map.get(ch));
            }
            
            max = Math.max(max, i - start + 1);
            map.put(ch, i+1);
        }
        
        return max;
    }
}