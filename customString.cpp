// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <unordered_map>

using namespace std;
class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> mp;
        string ans;
        for (auto& c:s){
            mp[c]++;
        }
        for(auto& c:order) {
            if(mp.find(c)!=mp.end()) {
                while (mp[c]-- > 0){
                    ans+=c;
                }
            }
        }
        cout<<mp.size();
        for(auto& c: mp){
            while (mp[c.first]-- >0){
                ans+=c.first;
            }
        }
        return ans;
    }
};