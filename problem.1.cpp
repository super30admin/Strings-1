// t-c: m+n
// s-c: 1
class Solution {
public:
    string customSortString(string order, string s) {
        string result = "";
        unordered_map<char, int> imap;
        for(int i = 0; i < s.size(); i++)
            imap[s[i]]++;
        for(int i = 0; i < order.size(); i++)
        {
            if(imap.find(order[i]) != imap.end())
            {
                for(int j = 0; j < imap[order[i]]; j++)
                {
                    result += order[i];
                }
                imap.erase(order[i]);
            }
        }
        for(auto itr: imap)
        {
            for(int i = 0; i < itr.second; i++)
            {
                result += itr.first;
            }
        }
        return result;

    }
};
