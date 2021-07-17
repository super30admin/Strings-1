// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    string customSortString(string order, string s) {
        
        string ret_str;
        int i, j;
        map<char, int> str_map;
        map<char, int>::iterator itr;

        // Add all characters of string in map and maintain count of occurrences        
        for(i = 0; i < s.size(); i++)
        {
            if(str_map.find(s[i]) != str_map.end())
                str_map[s[i]] += 1;
            else
                str_map.insert({s[i], 1});
        }
        
        // Add the order elements first 
        for(i = 0; i < order.size(); i++)
        {
            char c = order[i];

            // Add the apt number of times
            for(j = 0; j < str_map[c]; j++)
                ret_str += c;
            
            str_map.erase(c);
        }
        
        // Add the remaining characters from string
        for(itr = str_map.begin(); itr != str_map.end(); itr++)
        {
            char c = itr->first;
                
            for(j = 0; j < str_map[c]; j++)
                ret_str += c;
            
            str_map.erase(itr->first);
        }
        
        return ret_str;
    }
};