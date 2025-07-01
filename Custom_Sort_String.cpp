//Time Complexity : O(n+m)
//Space Complexity : O(1)
#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> freq;
        for (char ch : s)
            freq[ch]++;
        string ans = "";
        for (char ch : order) {
            while (freq[ch] > 0) {
                ans += ch;
                freq[ch]--;
            }
        }

        for (char ch : s) {
            if (freq[ch] > 0) {
                ans += ch;
                freq[ch]--;
            }
        }

        return ans;
    }
};
