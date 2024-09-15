package strings1;

/*
Idea : 	1. Put the elements of unsorted array and their corresponding counts in hashmap.
 		2. Iterate over whole custom sorted array, check whether the elements are present in hashmap and 
 		// append the result string with that character till its count is 0. (all common characters from T are arranged according to the custom order of S)
 		3. Now add remaining characters from T in the result.
Time Complexity : O(m + n) where m and n are the number of letters in S and T strings
Space Complexity : O(2n) where n is the number of characters in string T (once by hashmap and once by string builder).
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

import java.util.HashMap;

public class CustomSortString {

	public String customSortString(String S, String T) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char s : T.toCharArray()) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(char s : S.toCharArray()) {
            if(hm.containsKey(s)) {
            count = hm.get(s);
                hm.remove(s);
                while(count > 0) {
                  sb.append(s);  
                    count --;
                }    
            }    
        }
       for(char key : hm.keySet()) {
           count = hm.get(key);
           while(count > 0) {
               sb.append(key);
               count --;
           }
       }
        return sb.toString();
    }
	
}
