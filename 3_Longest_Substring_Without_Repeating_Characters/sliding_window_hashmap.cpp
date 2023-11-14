#include<bits/stdc++.h>
using namespace std;

/*
Approach: Sliding Window + Hashmap: Keep increasing window. When we encounter a previously available value, we increment the start to +1 of the index where it was found. However, this idx might already be before st, so we keep a check for that.
Time: O(n)
Working on leetcode: Yes
*/
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLen=0;
        int st=0, end=0;
        char c;
        unordered_map<char, int> lastOccIdx;
        for(; end<s.size(); end++) {
            c=s.at(end);
            if(lastOccIdx.find(c) != lastOccIdx.end()) {
                st = max(st, lastOccIdx[c]+1);
            }
            lastOccIdx[c] = end;
            maxLen = max(maxLen, end-st+1);
        }
        return maxLen;
    }   
};

int main() {
    Solution S;
    cout<<S.lengthOfLongestSubstring("pwwkew")<<endl;
}