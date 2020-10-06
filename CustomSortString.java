/*
 * #791. Custom Sort String
 * 
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

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

1. S has length at most 26, and no character is repeated in S.
2. T has length at most 200.
3. S and T consist of lowercase letters only.

 */


/*
 * Time Complexity: O (T + S) -> 'T' - number of characters in string 'T' and 'S' -> number of characters in string 'S'
 * 
 * Space Complexity: O (T) -> HashMap to store the characters and its count in string 'T'
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.strings1;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	public String customSortString(String S, String T) {
        
        // #1. Base condition
        if(S == null || T == null){
            return "";
        }
        
        // #2. Create a Hashmap to store the character and its frequency in string 'T'
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        // #3. Traverse through the string 'T' and store the count of each character in a map
        for(int i = 0; i < T.length(); i++){
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // #4. Create an output string
        String output = "";
        
        // #5. Traverse through the string 'S' and permute the characters of string 'T' to match the custom sort order of 'S'
        for(int j = 0; j < S.length(); j++){
            char ch = S.charAt(j);
    
            if(map.containsKey(ch)){
                int count = map.get(ch);
                
                while(count > 0){
                    output += ch;
                    count -= 1;
                }
                
                map.remove(ch);
            }
        }
        
        // #6. Append the remaining characters from a map to output string which are not present in string 'S'
        
        // Traverse through each key value pair in a map and append the characters to output string
        // map.entrySet() -> each key value pair in a map
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();
            
            while(count > 0){
                output += ch;
                count -= 1;
            }
        }
        
        return output;
    }

}
