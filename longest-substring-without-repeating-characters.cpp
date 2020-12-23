// Time Complexity : O(n) n = sting size
// Space Complexity : O(1) // max size of map can be 26 only
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        //edge
        if(s.size() == 1) return 1;
        int slow = 0;
        int maxSubStr = 0;
        unordered_map<char, int> mp;
        for(int i = 0; i < s.size(); i++) {
            if(mp.find(s[i]) != mp.end()) {
                if(slow <= mp[s[i]]) {
                    slow = mp[s[i]]+1;
                }
            }
            mp[s[i]] = i;
            maxSubStr = max(maxSubStr, i-slow+1);
        }
        return maxSubStr;
    }
};
