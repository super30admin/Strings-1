// Time Complexity :O(m+n) where m & n are str and ord 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    string customSortString(string order, string str) {
        unordered_map<char,int> hMap;
        for(int i = 0;i < str.length();i++){
            auto c = str[i];
            hMap[c]++;
        }
        string ans;
        for(int i = 0;i<order.length();i++){
            auto c = order[i];
            if(hMap.count(c)){
                int count  = hMap[c];
                while(count){
                    ans+=c;
                    count--;
                }
                hMap.erase(c);
            } 
        }
        for(auto c : hMap){
            int count = c.second;
            while(count){
                ans+=c.first;
                count--;
            }
        }
        return ans;
    }
};