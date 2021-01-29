/*
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        slow = 0
        max_length = 0
        mapping = {}
        # final_str = []
        for fast in range(len(s)):
            if s[fast] in mapping:
                slow = max(slow, mapping[s[fast]])
                
            if fast-slow+1 > max_length:
                max_length = fast-slow+1
#                 final_str = []
#                 final_str.append(s[slow:fast+1])
                
#             elif fast-slow+1 == max_length:
#                 final_str.append(s[slow:fast+1])
                
            mapping[s[fast]] = fast+1
            
        # print(final_str)
        return max_length
*/

// Time Complexity : O(N) where n is length of string
// Space Complexity : O(1) as there are 26 alphabets only
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: I used two pointer technique and hashmap to effectively store indexes
// and calculate max string

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0, max = 0;
        // List<String> li = new ArrayList<>();
        for (int fast=0; fast<s.length(); fast++){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            if (fast-slow+1 > max){
                max = fast-slow+1;
                // li = new ArrayList<>();
                // li.add(s.substring(slow, fast+1));
            }
            // else if(fast-slow+1 == max){
            //     li.add(s.substring(slow, fast+1));
            // }
            map.put(c, fast+1);
        }
        // System.out.println(li);
        return max;

    }
}