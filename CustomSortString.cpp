class Solution {
public:
    string customSortString(string order, string s) {
        // create a map
        unordered_map<char, int>freq_map;
        string result;
        for(char c : s)
        {
            freq_map[c]++;
        }

        for(char c : order)
        {
            if(freq_map.find(c)!= freq_map.end())
            {
                result.append(freq_map[c],c);
                freq_map.erase(c);
            }
        }

        // add the remaining 
        for(auto &pair : freq_map)
        {
            result.append(pair.second, pair.first);
        }
        return result;
    }
};
//Time complexity O(m+n)
//space complexity O(1) because of the resitriction of lowercase english letter
