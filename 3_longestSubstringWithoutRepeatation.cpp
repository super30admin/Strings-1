// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.empty() || s.length() == 0)
            return 0;
        int Max = INT_MIN;
        unordered_map<char, int> map;
        int p1=0;
        for(int i=0; i<s.length(); i++){
            char c = s[i];
            if(map.find(c) != map.end()){
                p1 = max(p1, map[c]);
                map[c] = i+1;
            }
            else{
                map.insert({c, i+1});
            }
            Max = max(Max, i-p1+1);
        }
        return Max;
    }
};
