/**
 * TC: O(m + n) where m is the  length of order string and n is the length of str string
 * SC: O(1) because the frequencies array is always of size 26
 * Approach: 
    Build a Data Structure to store the frequencies of each character in string str
    Loop through order str character by character from beginning to end, and for each of that character, append that character its frequency times in the stringbuilder
    Then check for each character that was absent in order str, append that character its frequency times in the stringbuilder
 */

class Solution {
    public String customSortString(String order, String str) {
        // edge case
        if(order == null || str == null || order.length() == 0 || str.length() < 2) {
            return str;
        }
        
        // frequencies array to store the frequency of each character in string str
        int[] frequencies = new int[26];
        // stringbuilder to build the permutated string
        StringBuilder permutatedStr = new StringBuilder();
        
        // store the frequencies of each character in frequencies array
        for(char ch : str.toCharArray()) {
            frequencies[ch - 'a']++;
        }
        
        // Loop through the order string
        // Find the frequency of each character in order string and append that character frequency times 
        for(char ch : order.toCharArray()) {
            // get frequency of the character in order string
            int frequency = frequencies[ch - 'a'];
            
            // append the character its frequency times in the stringbuilder
            for(int i = 0 ; i < frequency ; i++) {
                permutatedStr.append(ch);
            }
            
            // set the frequency of that character to  -1 indicating that character has been appended into stringbuilder
            frequencies[ch - 'a'] = -1;
        }
        
        // Loop through the frequencies array to process those characters that are there in str string but not in order string
        for(int i = 0 ; i < 26 ; i++) {
            // get frequency of the character in order string
            int frequency = frequencies[i];
            
            // append the character its frequency times in the stringbuilder
            for(int j = 0 ; j < frequency ;j++) {
                permutatedStr.append((char)(i + 'a'));
            }
            
            // set the frequency of that character to  -2 indicating that character has been appended into stringbuilder
            frequencies[i] = -2;
        }
        
        // return result
        return permutatedStr.toString();
    }
}
