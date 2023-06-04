// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we maintain the frequency of string s and then traverse through the string order and add to our result accordingly.

class Solution {
public:
    string customSortString(string order, string s) {
        vector<int>cnt(26,0);
        for(char ch: s)
        {
            int idx = ch - 'a';
            cnt[idx]++;
        }
        string result;
        for(char ch: order)
        {
            int idx = ch - 'a';
            while(cnt[idx]>0)
            {
                result+= ch;
                cnt[idx]--;
            }
        }
        for(int i = 0;i<26;i++)
        {
            while(cnt[i]>0)
            {
                result+= i+'a';
                cnt[i]--;
            }
        }
        return result;
    }
};