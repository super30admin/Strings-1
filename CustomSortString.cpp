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
    string customSortString(string order, string s) {
        map<char,int> mp;
        string result="";
        for(auto &c : s)
        {
            if(mp.find(c)==mp.end())
            {
                mp[c]=0;
            }
            mp[c]++;
        }
        
        for(auto &c : order)
        {
            if(mp.find(c)!=mp.end())
            {
                for(int i=0;i<mp[c];i++)
                {
                    result+=c;
                }
                mp.erase(c);
                
            }
        }
        
        for(auto &c : mp)
        {
            for(int i=0;i<c.second;i++)
            {
                result+=c.first;
            }
        }
        return result;
    }
};