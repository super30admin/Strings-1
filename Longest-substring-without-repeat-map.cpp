// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using two pointers to iterate through the array and store indexes of char in map.
// If repeation occurs, more the start pointer to currIndex+1 and update curr pointer to recent.

// 3. Longest Substring Without Repeating Characters

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i = 0, j = 0, n=s.length();
        unordered_map<char,int> mp;
        int count = 0;
        while(j < n){
            if(mp.find(s[j]) != mp.end()){
                i = max(mp[s[j]]+1,i);
            }
            mp[s[j]] = j;
            count = max(count,j-i+1);
            j++;
        }
        return count;
    }
};