class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> um;
        int maxLen=0;
        int start=0;
        for (int i=0;i<s.length();i++) {
            if (um.contains(s[i])) {
                start = max(start, um[s[i]]+1);
            }
            maxLen = max(maxLen, i-start+1);
            um[s[i]] = i;
        }
        return maxLen;
    }
};
