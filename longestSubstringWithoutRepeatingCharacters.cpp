//time complexity:O(n*3)
//space complexity:O(min(m,n))
//executed on leetcode: yes
//approach:using brute force
//any issues faced? no
//approach 1

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans=0;
        for(int i=0; i<s.size(); i++)
        {
            for(int j=i+1; j<=s.size(); j++)
            {
                if(unique(s,i,j))
                    ans=max(ans,j-i);
            }
        }
        return ans;
    }
    bool unique(string s, int start, int end)
    {
        set<char>set;
        for(int i=start; i<end; i++)
        {
            if(set.find(s[i])!=set.end())
                return false;
            set.insert(s[i]);
        }
        return true;
    }
};


//approach 2
//time complexity:O(2n)
//space complexity:O(min(m,n))
//executed on leetcode: yes
//approach:using sliding window
//any issues faced? yes but understood
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans=0;
        set<char>set;
        int n=s.size();
        int i=0, j=0;
        while(i<n && j<n)
        {
            if(set.find(s[j])==set.end())
            {
                set.insert(s[j]);
                j++;
                ans=max(ans,j-i);
            }
            else
            {
                set.erase(s[i]);
                i++;
            }
        }
        return ans;
    }
};