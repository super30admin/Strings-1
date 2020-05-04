//time complexity: O(lenght of longer string)
//space complexity: O(26) ~ O(1)

import java.util.*;
class Solution {
    public String customSortString(String S, String T) {
        Set<Character> charSet = new HashSet<>();
        int[] T_arr = new int[26];
        Arrays.fill(T_arr, -1);
        
        for(char c: T.toCharArray())
        {
            T_arr[c-'a'] += 1;      // O(length of T)
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < S.length(); i++)     // O(length of S)
        {
            charSet.add(S.charAt(i));
            
            while (T_arr[S.charAt(i) - 'a'] >= 0)
            {
                sb.append(S.charAt(i));
                T_arr[S.charAt(i) - 'a'] -= 1;
            }
            
        }
        
        for(int i = 0 ; i < T.length(); i++)    // O(length of T)
        {
            if(!charSet.contains(T.charAt(i)))
            {
                sb.append(T.charAt(i));
            }
        }
        
        return sb.toString();
    }
}