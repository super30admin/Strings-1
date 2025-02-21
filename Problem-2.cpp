/*
TC : O(n)
SC : O(1)
*/
class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        if (s.size() == 0 || s.empty())
        {
            return 0;
        }

        int count = 0, start = 0;
        map<char, int> hashMap;

        for (int i = 0; i < s.size(); i++)
        {
            if (!hashMap.empty())
            {
                // if the char exists
                if (hashMap.find(s[i]) != hashMap.end())
                {
                    if (start < hashMap[s[i]])
                    {
                        start = max(start + 1, hashMap[s[i]]);
                    }
                    hashMap[s[i]] = i + 1;
                    count = max(count, i - start + 1);
                }
                else
                { // if the char does not exists
                    hashMap.insert({s[i], i + 1});
                    count = max(count, i - start + 1);
                }
            }
            else
            {
                hashMap.insert({s[i], i + 1});
                count = max(count, i - start + 1);
            }
        }

        return count;
    }
};