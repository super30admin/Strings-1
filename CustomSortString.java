class Solution {
// Time Complexity : O(N) N+26 N:length of T string, 26: max length of S String
// Space Complexity : O(1)  maximum could be 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 HashMap:
 1. Use HashMap to store the count of characters of T.
 2. First the characters of String S in T, and then rest
 */
    public String customSortString(String S, String T) {
      StringBuilder result = new StringBuilder();
      HashMap<Character,Integer> hm = new HashMap<>();
      for(int i =0; i<T.length();i++){
          char ch = T.charAt(i);
          hm.put(ch, hm.getOrDefault(ch,0)+1);
      }
      for(int i=0; i<S.length();i++){
          char ch = S.charAt(i);
          if(hm.containsKey(ch)){
              int count = hm.get(ch);
          while(count > 0){
              result.append(ch);
              count--;
          }
          hm.remove(S.charAt(i));
         } 
      }
      for(Map.Entry<Character,Integer> entry : hm.entrySet()){
          char ch = entry.getKey();
          int count = entry.getValue();
          while(count > 0){
              result.append(ch);
              count--;
          }   
      }
      return result.toString();
    } 
}