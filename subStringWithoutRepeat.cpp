// Time Complexity :O(n) where n is the size of the string
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(!s.length()) return 0;
        unordered_map<char,int> hMap;
        int slow = 0;
        int fast = 0;
        int maxlen = INT_MIN;
        while(fast < s.length()){
            char c = s[fast];
            if(hMap.count(c)){
                slow = max(slow,hMap[c]);
            }
            hMap[c] = fast+1;
            maxlen = max(maxlen,fast-slow+1);
            fast++;
        }
        return maxlen;
    }
};