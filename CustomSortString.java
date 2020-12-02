package Dec1;

import java.util.HashMap;
import java.util.Map;

class CustomSortString {
    public String customSortString(String S, String T) {
        
        /*
        Time complexity: O(m+n) where m is length of string S and n is length of string T.
        Space complexity: O(1) because although hashmap used for storing freq of characters of target string, still its size can be 26 in the worst case(prob statment mentions lowercase characters only).So, it is a constant space solution.
        */
        
        Map<Character, Integer> hm = new HashMap<>();
        
        // add all characters of the target string with frequency
        for (int i = 0; i < T.length(); i++) {
            char curChar = T.charAt(i);
            hm.put(curChar, hm.getOrDefault(curChar, 0) + 1);
        }
         
        StringBuilder sb = new StringBuilder();
        
        // iterate through each character of the pattern string and check if it is in the freq map for target string. 
        // if yes: append in a stringbuilder that character for the number of times the freq map contains the value corresponding to that character.
        //          remove entry for that character from hashmap once appending to stringbuilder is done.
        // if no: do nothing and iterate for next character of pattern string
        for (int i = 0; i < S.length(); i++) {
            char curChar = S.charAt(i);
            if (hm.containsKey(curChar)) {
                int curFreq = hm.get(curChar);
                while (curFreq > 0) {
                    sb.append(curChar);
                    curFreq--;
                }
                hm.remove(curChar);
            }
        }
     
        // for adding the characters in result string which are only present in target string but not in pattern, iterate through the freq map and add the characters present as keys as many no.of times as their value is present in the hashmap.
        for (char c: hm.keySet() ) {
            int curFreq = hm.get(c);
            while (curFreq > 0) {
                 sb.append(c);
                 curFreq--;
            }
        }
        
        return sb.toString();
        
    }
}