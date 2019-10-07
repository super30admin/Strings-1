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

 * Solution 2: Using two pointer approach 
 * Time complexity :O(n)
  * Space complexity : O(n) using hash set to keep track of duplicates 
 *
 */


    /*
    /*
    * Approach in detail"
    * Start with each character in the string and then try to see what is the longest subsequence in the string which has no
      duplicates. Use hash table to store this info and once we get a duplicate entry in hash. record the length and update it
      if it is larger than existing one.

      The solution fails for a string of size 31000 due to time limit constraints. 
     *
     * 
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

    /*
    *  The approach works by using two pointers in the following manner
    *   start idx1 and idx2 with 0th position ie p.
    *      p w w k e w p w w k e w
    *
    * Keep moving idx2 to the right and also adding the char in hash set unless we get a character already in our hash set.
    * ie here in this case on 2nd index we will get w as repeat.
    * so idx1 will move one position to the right as the window needs to shift now. before doing that get the length of result
       by idx2 - idx1 and also store it in fin_len if it is greater than the existing result stored in fin_len. 
    *  so once we get p w as string new indexes are :
    *
    *     i1   i2
    *      p   w   w    k   e   w   p   w   w   k   e   w
    *
    *      i1     i2 <found duplicate move index and update result> stored length of result pw as 2 in fin_len
    *      p   w   w    k   e   w   p   w   w   k   e   w
    *     
    *
    *        i1    i2
    *      p   w   w    k   e   w   p   w   w   k   e   w   
    *
    *             i1=2, i2=2
    *      p   w   w    k   e   w   p   w   w   k   e   w   
    *
    * Keep on moving like this and get the result 
    */
    int lengthOfLongestSubstring_ver2(string s) {
        int idx1 = 0, idx2 = 0;
        int fin_len = 0, temp_len = 0;
        int st_len = s.length();
        
        if (!st_len) {
            return fin_len;
        }
        
        unordered_set<char> hset;        
        while(idx1 < st_len && idx2 < st_len) {
            /* Got a duplicate, time to move the sliding window and also update the result */
            if (hset.find(s[idx2]) != hset.end()) {
                temp_len = idx2 - idx1;
                if (temp_len > fin_len) {
                    fin_len = temp_len;
                }
                hset.erase(s[idx1]);
                idx1++;
            } else {
                hset.insert(s[idx2]);
                idx2++;
            }
        }
        /* I reached the end, let me check if there is still any result pending */
        if (idx2 == st_len) {
            temp_len = idx2 - idx1;
            if (temp_len > fin_len) {
                fin_len = temp_len;
            }
        }

        return fin_len;
    }
};
/* Execute on leetcode platform */


