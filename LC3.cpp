// Time complexity O(n)
// Space complexity O(1)
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char, int> store;
        
        int maximum = 0;
        int current = 0;
        
        int l = 0;
        for (int r = 0; r < s.length(); r++)
        {
            char ch = s[r];
            auto it = store.find(ch);
            if (it != store.end())
            {
                if (it->second < l)
                {
                    it->second = r;
                }
                else
                {
                    l = it->second + 1;
                }
            }
            store[ch] = r;

            current = r - l + 1;
            if (current > maximum)
            {
                maximum = current;
            }

        }

        return maximum;
    }
};