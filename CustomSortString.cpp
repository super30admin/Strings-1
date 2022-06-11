// Time Complexity : O(m + n) 
//                  where m : length of i/p string
//                        n : length of order
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build a hash map using i/p string to store char and its frequency. Iterate over order string, if current char is present in hashmap then
 * add that char to result string number of times its frequency. At the end add all the remaining chars of map in the result string.   
 */

class Solution {
public:
    string customSortString(string order, string s) {
        if (s.empty())
            return "";
        
        unordered_map<char, int> map;
        
        for (char& c : s)
        {
            if (map.find(c) == map.end())
            {
                map.insert({c, 0});
            }
            
            map.find(c)->second += 1;
        }
        
        string result = "";
        for (char& c : order)
        {
            if (map.find(c) != map.end())
            {
                int times = map.find(c)->second;
                
                while (times--)
                {
                    result += c;
                }
                
                map.erase(c);
            }
        }
        
        for (auto& ele : map)
        {
            int times = ele.second;
            
            while (times--)
            {
                result += ele.first;
            }
        }
        
        return result;
    }
};