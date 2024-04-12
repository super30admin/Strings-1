class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> iset;
        int i = 0, j = 0, c = 0, maxi = 0;
        while(j < s.size())
        {
            if(iset.find(s[j]) != iset.end())
            {
                maxi = max(maxi, c);
                while(s[i] != s[j])
                {
                    iset.erase(s[i]);
                    i++;
                    c--;
                }
                i++;
                j++;
            }
            else
            {
                iset.insert(s[j]);
                c++;
                j++;
            }
        }
        return max(maxi,c);
    }
};
