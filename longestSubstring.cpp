class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> mp; 
        int maxLength = 0; 
        int windowStart = 0; 

        for(int windowEnd = 0; windowEnd < s.size(); windowEnd++) {
            if(mp[s[windowEnd]] > 0) {
                windowStart = max(mp[s[windowStart]], windowStart);
            }
            maxLength = max(maxLength, windowEnd - windowStart + 1);
            mp[s[windowEnd]] = windowEnd + 1; 
        }

        return maxLength; 
    }
};