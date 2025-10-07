// Problem name: Longest String without repeating chars
// Time Complexity : O(n)
// Space Complexity : O(1) map has only ascii chars
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We keep a left pointer that points to start of the window
// 2. We check if we have previously seen this char, if yes we jump our left
// pointer to the max left or frequency of this char, this is to check whether
// char in repeating in substring or outside of subtring window
// 3. Calculate max after each char is procesed and update the freq map with
// latest index

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    int left = 0;
    int maxi = 0;
    unordered_map<int, int> u;
    for (int i = 0; i < s.size(); i++) {
      char ch = s[i];
      // if we have found a repeating character, jump the left pointer
      if (u.count(ch) > 0) {
        left = max(u[ch] + 1, left);
      }
      maxi = max(maxi, i - left + 1);
      u[ch] = i;
    }

    return maxi;
  }
};
