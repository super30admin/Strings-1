// Time Complexity : O(n + m) where n is the length of the order string and m is the length of the string s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Count the frequency of each character in the string s.
 * 2. Iterate over the order string and append the character to the result string the number of times it is present in the string s.
 * 3. Iterate over the frequency array to append remaining characters.
 * 4. Return the result string.
 */

class Solution {
    public String customSortString(String order, String s) {
        int[] charMap = new int[26];
        for(char ch : s.toCharArray()){
            charMap[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for(char ch : order.toCharArray()){
            int freq = charMap[ch - 'a'];
            if(freq == 0)
                continue;
            
            for(int i=0; i<freq; i++){
                result.append(ch);
            }
            charMap[ch - 'a'] = 0;
        }

        for(int i=0; i<26; i++){
            int freq = charMap[i];
            char ch = (char) (i + 'a');
            if(freq == 0)
                continue;
            
            for(int k=0; k<freq; k++){
                result.append(ch);
            }
        }

        return result.toString();
    }
}