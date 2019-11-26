 
 TC: O(T.length())
 SC: O(T.length())
 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Custom Sort String.
Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Custom Sort String.
 
 Approach: First we take the count of T characters in count array. Then we traverse through the S array and append all characters by the 
 number of times they are in T array to a new String. Then we append the characters that are in T but not in S to the end.
 
 
 class Solution {
 
 public String customSortString(String S, String T) {
       int[] count = new int[26];
        for (char c : T.toCharArray())
        { ++count[c - 'a'];
        }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {                            
            while (count[c - 'a']-- > 0)
                { sb.append(c); 
                }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) 
                { sb.append(c); 
                }    // group chars in T but not in S.
        }
        return sb.toString(); 
   }
   }
