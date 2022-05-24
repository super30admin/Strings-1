/* 
    Time Complexity                              :  O(N) where N is the size of the string
    Space Complexity                             :  O(N) used in the hashmap
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // return usingHashMap(s);
        return usingArrays(s);
    }
    
    int usingHashMap(string s) {
        int l=0, r=0;
        unordered_map<char, int> mp;
        int mx = INT_MIN;
        while(r < s.size()) {
            char ch = s[r];
            mp[ch]++;
            while(mp[ch] > 1) {
                mp[s[l]]--;
                l++;
            }
            mx = max(mx, r-l+1);
            r++;
        }
        return mx == INT_MIN ? 0 : mx;
    }
    
    
    int usingArrays(string s) {
        vector<int> freq(256,0);
        int l=0,r=0,mx=0;
        while(r < s.size()) {
            freq[s[r]]++;
            while(freq[s[r]] > 1) {
                freq[s[l]]--;
                l++;
            }
            mx = max(mx, r-l+1);
            r++;
        }
        
        return mx;
    }
};