/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
791. Custom Sort String
Medium

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

 

Note:

    S has length at most 26, and no character is repeated in S.
    T has length at most 200.
    S and T consist of lowercase letters only.




 * Solution 1: using hash array.  
 * Time complexity: O(n+m) :  n is size of S, m is size of T
 * space complexity: O(1) as the array size is also fixed ie 26 letters.

 *
 */


    /*
    /*
    * Approach in detail"
    * 1. Get length of both strings. We already know that S has always unique characters. so lets take an simple hash array where
     * we can count each char frequency.
     * 2. record the frequency of char in T string .
     * 3. Scan char in S in the hash array. Whatever is found, make it zero.
     * 4. By doing this, once we scan it again, we can get the char which are not in the S string and create the result.
     * 5. Kindly note that here order is maintained as we are storing the char in result in order in which S stores it.
    */
class Solution {
public:
    string customSortString(string S, string T) {
        int hash_arr[26] = {0};
        int idx = 0;
        int s_len = S.length();
        int t_len = T.length();
        string final_str;
        
        for (idx = 0; idx < 26; idx++) {
            hash_arr[idx] = 0;
        }
        
        for (idx = 0; idx < t_len; idx++) {
            hash_arr[T[idx] - 'a']++;
        }
        
        for (idx = 0; idx < s_len;idx++) {
            if (hash_arr[S[idx] - 'a'] != 0) {
                for (int idx1 = 0; idx1 < hash_arr[S[idx] - 'a']; idx1++)
                    final_str.push_back(S[idx]);
                hash_arr[S[idx] - 'a'] = 0;
            }
        }
        
        for (idx = 0; idx < 26; idx++) {
            if (hash_arr[idx] != 0) {
                for (int idx1 = 0; idx1 < hash_arr[idx]; idx1++)
                    final_str.push_back(idx + 'a');
            }
        }
        return final_str;
    }
};
/* Execute on leetcode platform */


