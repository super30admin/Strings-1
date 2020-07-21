// Time Complexity : o(2S+T)
// Space Complexity : o(1) - since we have 27 char, frequency hashmap will take constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/custom-sort-string/submissions/
 */
class Solution {
    public String customSortString(String S, String T) {
       Map<Character, Integer> charCountMap = new HashMap<>();
       
       
       //create frequency map out of T
       for(int i=0; i<T.length();i++){
           char c = T.charAt(i);
           charCountMap.put(c, charCountMap.getOrDefault(c,0) + 1);
       }
        
       StringBuilder sb = new StringBuilder();
        
       //for every char in S, if its in T, append to result based on its freq in T and remove from the map 
       for(int i=0; i<S.length();i++){
           char c = S.charAt(i);
           if(charCountMap.containsKey(c)) {
               int cnt = charCountMap.get(c);
               
               while(cnt > 0) {
                   sb.append(c);
                   cnt--;
               }
               
              charCountMap.remove(c); 
           }
    }
      
       //Append remaining chars from T to result
    for(Map.Entry<Character, Integer> entry:charCountMap.entrySet()){
        char c = entry.getKey();
        int cnt = entry.getValue();
        
        while(cnt > 0) {
           sb.append(c);
           cnt--;
        }
    }
        
        return sb.toString();
}
    
}