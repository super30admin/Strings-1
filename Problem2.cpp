/* Problem Statement:

3. Longest Substring Without Repeating Characters
Medium

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



 * Solution 1: using hash set, but TIME LIMIT EXCEEDED 
 * Time complexity: O(n) 
 * space complexity: O(n)
 */


    /*
    /*
    * Approach in detail"
    * Start with each character in the string and then try to see what is the longest subsequence in the string which has no
      duplicates. Use hash table to store this info and once we get a duplicate entry in hash. record the length and update it
      if it is larger than existing one.

      The solution fails for a string of size 31000 due to time limit constraints. 
     *
     *  TODO: NEED TO IMPROVE THE ALGORITHM 
    */
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int idx = 0, idx1 = 0;
        int fin_len = 0, temp_len = 0;
        int st_len = s.length();
        int st_idx = 0, end_idx = -1;
        
        /* validations */
        if (!st_len) {
            return fin_len;
        }
  
        unordered_set<char> hset;
        
        for (idx1 = 0; idx1 < st_len;idx1++) {
            temp_len = 1;
            hset.clear();
            hset.insert(s[idx1]);

            /* with each character, start iterating over the remaining char in the array */
            for (idx = idx1 + 1; idx < st_len; idx++) {
                /* found duplicate. time to record result and update it if needed */
                if (hset.find(s[idx]) != hset.end()) {
                    if (temp_len > fin_len) {
                        fin_len = temp_len;
                    }
                    temp_len = 0;
                    hset.clear();
                }
                hset.insert(s[idx]);
                temp_len++;
            }
            if (temp_len  > fin_len) {
                fin_len = temp_len;
            }
        }
        
        if (!fin_len) {
            fin_len = st_len;           
        }
        return fin_len;
    }
};
/* Execute on leetcode platform */


