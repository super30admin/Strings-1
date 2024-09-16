//Time Complexity-O(S)
//Space Complexity-O(S)
//Ran successfully on leetcode

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.empty())
            return 0;
        unordered_map<char,int>m;
        int count=0,slow=0,fast=0;
        while(fast<s.size() && slow<=fast)
        {
            if(m.count(s[fast]))
                slow=max(slow,m[s[fast]]);
            count=max(count,fast-slow+1);
            m[s[fast]]=fast+1;
            fast++;
        }
        return count;
    }
};