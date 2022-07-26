/*
SLIDING WINDOW PROBLEM: https://leetcode.com/problems/max-consecutive-ones-iii/
TC: O(n)SC: O(1)

Brute force -> keep two pointers i and j. i goes through each index in array. j goes from i to end. If element is 0, inc count. When count == k,
store length
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int zeroCount = 0;
        int windowStart = 0, windowEnd = 0;
        int maxLen = 0;
        
        for (windowEnd = 0; windowEnd < nums.length; ++windowEnd) {
            if (nums[windowEnd] == 0)
                ++zeroCount;
            
            while (zeroCount > k) {
                if (nums[windowStart] == 0) {
                    --zeroCount;
                }
                ++windowStart;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            
        }
        
        return maxLen;
    }
}