//time complexity:O(m*n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using brute force
//any issues faced? yes, not optimized

class Solution {
public:
    string customSortString(string S, string T) {
        
        set<char>set;
        string res="";
        for(int i=0; i<S.size(); i++)
        {
            for(int j=0; j<T.size(); j++)
            {
                if(S[i]==T[j])
                {
                    set.insert(T[j]);
                    res+=S[i];
                }
            }
        }
        for(int i=0; i<T.size(); i++)
        {
            if(set.find(T[i])==set.end())
                res+=T[i];
        }
        return res;
    }
};
