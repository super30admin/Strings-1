// Time complexity O(m+n)
// Space complexity O(1)
class Solution {
public:
    string customSortString(string order, string s) {
        
        vector<int> store(26, 0);
        for (char ch : s)
        {
            store[ch-'a']++;
        }

        std::stringstream ss;
        for (char ch : order) 
        {
            while (store[ch-'a'])
            {
                ss << ch;
                store[ch-'a']--;
            }
        }

        for (int i = 0; i < 26; i++)
        {
            while (store[i])
            {
                ss << (char)(i + 'a');
                store[i]--;
            }

        }
        
        return ss.str();
    }
};