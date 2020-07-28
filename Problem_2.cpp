class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int max = 0;
        vector<int>dict(128,-1);
        int start = 0;
        for(int end=0; end<s.length();  end++){
            if(dict[s[end]]>start){
                start = dict[s[end]];
            }
            dict[s[end]] = end+1;
            max = std::max(max, end-start+1);
        }
        return max;
    }
};