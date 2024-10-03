//time: O(n) space: O(1)
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        unordered_map<char,int> umap;
        int slow = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {
            char c = s[i];
            if(umap.find(c) != umap.end()) {
                slow = max(slow,umap[c]+1);
            }
            umap[c] = i;
            result = max(result,(i-slow+1));
        }
        return result;
    }
};