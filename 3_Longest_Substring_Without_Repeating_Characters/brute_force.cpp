#include<bits/stdc++.h>
using namespace std;

/*
Approach: Brute force: Create all substrings. For every substr, check if it doesn't have repeating characters. Maintain a global variable to track the longest substr;
Time: O(n^3)
Working on leetcode: Yes
*/
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLen=0;
        for(int st=0; st<s.size(); st++) {
            for(int end=st; end<s.size(); end++) {
                unordered_set<char> hset;
                bool nonRepeat = true;
                for(int i=st; i<=end; i++) {
                    char c= s.at(i);
                    if(hset.find(c) != hset.end()) {
                        nonRepeat = false;
                        break;
                    }
                    hset.insert(c);
                }
                if(nonRepeat)
                    maxLen = max(maxLen, end-st+1);
            }
        }
        return maxLen;
    }
};

int main() {
    Solution S;
    cout<<S.lengthOfLongestSubstring("pwwkew")<<endl;
}