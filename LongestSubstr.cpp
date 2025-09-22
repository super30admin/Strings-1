#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We take an array of size 256 and initiate it with values -1
we keep track of the left pointer and the right pointer and we update the the 
maxLen accordingly and then return the maxLen
*/
class Solution{
public:
    int lengthOfLongestSubstring(string s){
        int left = 0;
        int maxLen = 0;
        int map[256];
        fill(map, map+256, -1);
        for(int right=0; right<256; right++){
            char c = s[right];
            if(map[c] != -1) left = max(left, map[c]+1);
            map[c] = right;
            maxLen = max(maxLen, right-left+1);
        }
        return maxLen;
    }
};
