//Time Complexity-O(n)--> 'n' is the length of string
//Space Complexity-O(n)
//Did the code run on Leetcode? yes


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int count=0,ans=0,h=0;
        map<char,int>m;
        int i;
        for(i=0;i<s.length();i++)
        {
            if(m.find(s[i])==m.end())
            {
                m[s[i]]=i;
            }
            else
            {
                if(m[s[i]]>=count)
                {
                    if(h<i-count)
                    {
                        h=i-count;
                        
                    }
                    count=m[s[i]]+1;
                }
                m[s[i]]=i;
            }
        }
        if(h<i-count)
        {
            h=i-count;
        }
        return h;
    }
};