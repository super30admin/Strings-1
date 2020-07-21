//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<int,int> m;
        int slow = 0; int fast = 0;
        int max_val =0;
        
        while(fast<s.size()){
            if(m.find(s[fast])!=m.end()){
                slow = max(slow,m[s[fast]]);
                m[s[fast]]=fast;
            }
            m[s[fast]]=fast +1;
            max_val = max(max_val, fast-slow+1);
            fast++; 
        }
        
        return max_val;
        
        
    }
};