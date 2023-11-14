#include<bits/stdc++.h>
using namespace std;

/*
Approach: Hashmap: Create freq map for chars in 's'. Then iterating through the order append the char (to answer) as many times as it appears in 's'. At end if any chars from 's' are remaining then append them as well.
Time: O(n+m)
Working on leetcode: yes
*/
class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> freq;
        for(char c: s) {
            freq[c]++;
        }
        string ans = "";
        for(char c: order) {
            int cnt = freq[c];
            while(cnt--) {
                ans += c;
            }
            freq.erase(freq.find(c));
        }
        for(auto pr: freq) {
            int cnt = pr.second;
            char c = pr.first;
            while(cnt--) {
                ans+=c;
            }
        }
        return ans;
    }
};

int main() {
    string order="cbafg";
    string s="abcd";
    Solution S;
    cout<<S.customSortString(order,s)<<endl;
}