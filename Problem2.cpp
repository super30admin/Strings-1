
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Longest substring without repeating characters

#include<vector>
#include<iostream>
#include<unordered_map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char, int> m1;
        int max = 0;
        int slow = 0;
        
        for(int fast = 0; fast < s.size(); fast++){
            
            if(m1.find(s[fast]) == m1.end()){  // if not found
                m1[s[fast]] = fast + 1;
            }
            else{
                slow = std::max(slow, m1[s[fast]]);
                m1[s[fast]] = fast + 1;    // update the fast
            }
            
            max = std::max(max, fast - slow + 1);
        }
        return max;
    }
};