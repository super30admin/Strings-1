/*
Time Complexity = O(n)
Space COmplexity = O(1)
where n is the number of alphabet in the string.
Here space complexity is 1 because at max in the hashmap there can be only 26 alphabet.
*/
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length()==0)
            return 0;
        map<char,int> m;
        int slow = 0;
        int maxi = INT_MIN;
        for(int i=0;i<s.length();i++){
            if(m.find(s[i])!=m.end())
                slow = max(slow, m[s[i]]);
            m[s[i]]=i+1;
            maxi = max(maxi, i-slow+1);
        }
        return maxi;
    }
};
