// Time Complexity: O(n), where n is the length of the string s.
// Space Complexity: O(n), where n is the length of the string s.
// Did this code run successfully on LeetCode? Yes

// Approach: Sliding Window
// 1. Create a set to store the characters in the current substring.
// 2. Initialize two pointers, left and right, to the start of the string.
// 3. Iterate through the string using the right pointer.
// 4. If the character at the right pointer is not in the set, add it to the set.
// 5. Update the maximum length of the substring.
// 6. If the character at the right pointer is already in the set, remove characters from the left pointer until the character at the right pointer can be added.


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> set;
        int maxLen = 0; 
        int left = 0, right = 0;

        while(right < s.size()){
            if(set.find(s[right]) != set.end()){
                set.erase(s[left]);
                left++;
            }else{
                set.insert(s[right]);
                maxLen = max(maxLen, right - left + 1);
                right++;
            }
        }
        
        return maxLen;
        
    }
};