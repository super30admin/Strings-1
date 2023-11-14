#include<bits/stdc++.h>
using namespace std;

/*
Approach: Sliding window + Hashset: Keep increasing curr window. When we encounter an already existing char, remove the elements from the start until we don't have the repeated element. Keep track of max length.
Time: O(n)
Working on leetcode: Yes
*/
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLen=0;
        int st=0, end=0;
        unordered_set<char> currWinChars;
        for(; end<s.size(); end++) {
            char c=s.at(end);
            while(currWinChars.find(c) != currWinChars.end()) {
                currWinChars.erase(s.at(st));
                st++;
            }
            currWinChars.insert(c);
            maxLen = max(maxLen, end-st+1);
        }
        return maxLen;
    }   
};

int main() {
    Solution S;
    cout<<S.lengthOfLongestSubstring("")<<endl;
}