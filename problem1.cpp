/*
Time complexity: O(n+m)
Space complexity: O(n+m)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    string customSortString(string order, string str) {
        string ans;
        unordered_map<char, int>mp;
        
        for(int i = 0; i < str.size(); i++) 
            mp[str[i]]++;
        
        for(int i = 0; i < order.size(); i++)
            while(mp[order[i]] > 0){
                ans.push_back(order[i]);
                mp[order[i]]--;
            }
        
        for(auto i : mp)
            while(i.second > 0){
                ans.push_back(i.first);
                i.second--;
            }   
     return ans;
    }
};