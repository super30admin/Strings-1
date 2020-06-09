//Time Complexity-O(S+T)
//Space Complexity-O(T)
//Ran successfully on leetcode

class Solution {
public:
    string customSortString(string S, string T) {
        unordered_map<char,int>m;
        string result;
        for(char c:T)
            m[c]++;
        for(char c:S)
        {
            if(m.count(c))
            {
                while(m[c]>0)
                {
                    result.push_back(c);
                    m[c]--;   
                }
                m.erase(c);
            }
        }
        for(auto i:m)
        {
            int count=i.second;
            while(count>0)
            {
                result.push_back(i.first);
                count--;
            }
            //m.erase(i.first);
        }
        return result;
    }
};