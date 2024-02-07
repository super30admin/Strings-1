// Time Complexity : O(2N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using two pointers to iterate through the array and store unique chars in hashset.
// if repeation occurs, more the start pointer and delete from hashset.

// 3. Longest Substring Without Repeating Characters

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i = 0, j = 0, n=s.length();
        unordered_set<char> set;
        int count = 0;
        while(i < n && j < n){
            if(set.find(s[j]) == set.end()){
                set.insert(s[j]);
                j++;
                count = max(count,j-i);
            }
            else{
                set.erase(s[i]);
                i++;
            }
        }
        return count;

    }
};