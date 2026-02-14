
    /**
    Time Complexity = O(N)
    Explanation:
    Sliding window approach. Each character is added to the set once and removed at most once.
    So total operations across left and right pointers is linear.

    Space Complexity = O(1)
    Explanation:
    Set stores at most 26/128/256 characters depending on charset (bounded), so constant space.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially got wrong answers because I didn’t remove characters correctly when duplicates occur.
    Also forgot to remove the duplicate character itself from the set, which can keep the set incorrect.
    Fixed it by moving the left pointer while removing characters until the duplicate is handled properly.
    */

    class Solution {


        public int lengthOfLongestSubstring(String s) {
    
            Set<Character> set = new HashSet<>();
            int left = 0;
            int right = 0;
            int res = 0;
            int n = s.length();
    
            while (right < n) {
                char c = s.charAt(right);
    
                if (!set.contains(c)) {
                    set.add(c);
                } else {
                    // remove until we reach the duplicate character
                    while (c != s.charAt(left)) {
                        set.remove(s.charAt(left));
                        left++;
                    }
                    // move left past the duplicate
                    left++;
                }
    
                res = Math.max(res, right - left + 1);
                right++;
            }
    
            return res;
        }
    }
    