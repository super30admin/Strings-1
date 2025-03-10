// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Time Complexity : O(n) where n is the length of the string s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Define a hastset. Declare two variables left and right at 0 whose purpose is to track the range of the substring.
// Iterate through the string, if it is not in the hashset, then add it's index value and calculate the length so far.
// If an element is already present, then move the left pointer to the right of the last index of the current element and then update it's new value.
// Calculate the maximum length and return.

class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            int n = s.length();
            if(n == 0) return 0;
            int maxlen = 0;
            int left=0; int right=0;
            vector<int> m(256,-1);
            while(right < n){
                if(m[s[right]] != -1){
                    left = max(left, m[s[right]]+1);
                }
                m[s[right]] = right;
                maxlen = max(maxlen, right-left+1);
                right++;
            }
            return maxlen;
        }
    };