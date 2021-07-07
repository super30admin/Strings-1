class Solution {
//Time Complexity-O(m+n)-->'m' is length of string S and 'n' is length of string Time
//Space Complexity-O(n)
//Did the code execute on Leetcode? Yes

public:
    string customSortString(string S, string T) {
       unordered_map<char,int>m;
        string res="";
        for(int i=0;i<T.length();i++)
        {
            m[T[i]]++;
        }
        for(int i=0;i<S.length();i++)
        {
            if(m.find(S[i])!=m.end())
            {
                int a=m[S[i]];
                while(a!=0)
                {
                    res=res+S[i];
                    a--;
                }
                m.erase(S[i]);
            }
        }
        for(auto i=m.begin();i!=m.end();i++)
        {
            if(i->second>0)
            {
                int b=i->second;
                while(b!=0)
                {
                    res=res+i->first;
                    b--;
                }
            }
        }
        return res;
    }
};