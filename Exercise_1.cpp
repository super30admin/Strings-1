/* 
    Time Complexity                              :  O(M+N) - where M  is the size of the order string and
                                                            N is the size of the s string.
    Space Complexity                             :  O(N) - to store the characters from s string
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    string customSortString(string order, string s) {
        
        return hashMapApproach(order, s);
    }
    
    string hashMapApproach(string order, string s) {
        unordered_map<char, int> mp;
        for(auto ch : s) {
            mp[ch]++;
        }
        string ans = "";
        for(auto ch : order) {
            if(mp.find(ch) != mp.end()) {
                for(int i=0;i<mp[ch];i++) {
                    ans += ch;
                }
                mp.erase(ch);
            }
        }
        
        for(auto m : mp) {
            for(int i=0;i<m.second;i++) {
                ans+=m.first;
            }
        }
        
        return ans;
    }
};