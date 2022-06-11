// Time Complexity : O(n) where n : length of i/p string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Use two pointers and hashmap. Initialize slow pointer to 0. Iterate over string using fast pointer.
 * While iterating check if current element is present is hashmap. If it is present then reset the slow pointer to location stored in hashmap.
 * Update the current element index in hashmap. Compute the current substring length using slow and fast pointers. 
 * If current substring length is greater than previous max then update the max.   
 */

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.empty())
            return 0;
        
        unordered_map<char, int> map;
        int slow = 0;
        int max = 0;
        
        for (int i = 0; i < s.size(); i++)
        {
            if (map.find(s[i]) != map.end())
            {
                slow = std::max(map.find(s[i])->second, slow);
                map.erase(s[i]);
            }
            
            max = std::max(max, i - slow + 1);
            map.insert({s[i], i + 1});
        }
        
        return max;
    }
};