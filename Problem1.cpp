// Problem name: Custom Sort String
// Time Complexity : O(m + n)
// Space Complexity : O(1) map has only 26 chars
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first make a frequency map of s string
// 2. Then we loop through the order string, and if we have a entry in map, we
// add to our result string with the freq and then erase it
// 3. After that, we add remaining chars in the map and append to the result
// string
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  string customSortString(string order, string s) {
    unordered_map<char, int> sf;
    for (int i = 0; i < s.size(); i++) {
      sf[s[i]]++;
    }

    string res = "";
    for (char ch : order) {
      if (sf.count(ch) > 0) {
        while (sf[ch]--) {
          res += ch;
        }
        sf.erase(ch);
      }
    }

    for (auto it : sf) {
      while (it.second--) {
        res += it.first;
      }
    }
    return res;
  }
};
