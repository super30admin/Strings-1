//Time complexity: O(M+N), where M is the length of string str and N is the length of string order.
//Space complexity: O(1)

import java.util.*;

class Solution1 {
    public String customSortString(String order, String str) {
        int[] charMap = new int[26];
        for(char c: str.toCharArray()) {
            charMap[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder(); 
        for(char c: order.toCharArray()) {
            int i = c-'a';
            for(int count=0; count<charMap[i]; count++) {
                sb.append(c);
            }
            charMap[i] = 0; 
        }
        
        for(int i=0; i<26; i++) {
            char c = (char)(i+'a'); 
            for(int j=0; j<charMap[i]; j++) {
                sb.append(c);
            }
            charMap[i] = 0; 
        }
        
        return sb.toString(); 
    }
}