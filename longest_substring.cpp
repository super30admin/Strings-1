// Time Complexity : O(n*n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Can optimize to O(n) by avoiding to add elements in map on every reset

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        // Map to keep track of unique characters and their indices
        map<char, int> str_map;
        
        if(s.size() == 0)
            return 0;
        
        int i, j;
        char c;
        int max_count = -1;
        int temp_count = 0;
        
        // Traverse through the string and add only till unique characters
        // Reset if Element repeats
        for(i = 0; i < s.size(); i++)
        {
            c = s[i];

            // Character repeat condition   
            if(str_map.find(c) != str_map.end())
            {
                int num = str_map[c];
                str_map.clear();
                
                if(temp_count > max_count)
                    max_count = temp_count;
                
                // Add elements after the first occurrence of repeating character
                temp_count = 0;
                for(j = num+1; j <= i; j++)
                {
                    temp_count++;
                    str_map.insert({s[j], j});
                }
            }
            // New Character Condition
            else
            {
                str_map.insert({c, i});
                temp_count++;
            }
        }

        // Check for max_count      
        if(temp_count > max_count)
            max_count = temp_count;
        
        return max_count;
    }
};