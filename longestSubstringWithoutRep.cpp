"""
Intuition: Start with a hashset. The disadvante would be that we would be able to track where to start finding the next longest substring.
Make a hashmap of all characters inside the current pointers and store the index. 
If repition occurs, simply start from the index stored in the hashmap
#####################################################################
Time Complexity : O(N)  N = length of the original string.
Space Complexity : O(N), N = length of the original string.
#####################################################################
"""


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if ( s.size()==0) return 0;
        int maxLength = 0;
        int slow = 0;
        int fast = 0;
        map<char, int> map;
        while ( fast != s.size()){
            char letter = s[fast];
            
            if ( map.find(letter) == map.end()){
                map[letter] = fast;
            }
            else{
                slow = max(slow,map[letter] + 1);
                map[letter] = fast;
            }
            maxLength = max(maxLength, fast - slow + 1);
            fast++;
            
        }
        return maxLength;
    }
};