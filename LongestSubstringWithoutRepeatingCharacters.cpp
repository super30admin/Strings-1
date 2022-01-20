//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;



class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxCon=0;
        
        int left=0;
        int right;
        
        map<char,int> dict;
        map<char,int>::iterator it;
        int currentCon=0;
        
        for(right=0;right<s.size();right++)
        {
            it=dict.find(s[right]);

            if(it!=dict.end() && it->second>=left)
            {
                left=it->second+1;

                it->second=right;
            }
            else if(it!=dict.end() && it->second<=left)
            {
                it->second=right;
            }
            else
            {
                dict.insert({s[right],right});
            }

            maxCon=max(maxCon,right-left+1);

        }
        
        return maxCon;
    }
};