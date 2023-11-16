class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        unordered_map<char, int> map;
        int slow=0;
        int max1=0;
        for(int i=0;i<n;i++){
            char c = s[i];
            if(map.count(c)){
                slow = max(slow, map[c]+1);
            }
            map[c]=i;
            max1 = max(max1, i-slow+1);
        }
        return max1;
    }
};
