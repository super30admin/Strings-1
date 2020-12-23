// LeetCode #791. Custom Sort String
// Time Complexity : O(m+n) // m = size of string S; n = size of string T
// Space Complexity : O(1) // At max, 26 characters will be in the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    string customSortString(string S, string T) {
        unordered_map<char, int> mp;
        string res = "";
        for(char c : T) {
            mp[c]++;
        }
        
        for(char c : S) {
            for(int i = 0; i < mp[c]; i++) {
                res += c;
            }
            mp.erase(c);
        }
        
        for(auto it : mp) {
            for(int i = 0; i < it.second; i++) {
                res += it.first;
            }
        }
        return res;
    }
};
