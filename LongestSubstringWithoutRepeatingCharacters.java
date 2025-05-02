import java.util.HashMap;
import java.util.Map;

/*
//O(2n): 2 pointer and set
class Solution {
  public int lengthOfLongestSubstring(String s) {
      int n=s.length();
      int max=0;
      int i=0;
      int j=0;
      Set<Character> set=new HashSet<>();
      while(j<n){
         if(set.contains(s.charAt(j))){
              max=Math.max(max,j-i);
              while(i<n && s.charAt(i)!=s.charAt(j)){
                  set.remove(s.charAt(i));
                  i++;
              }
              
              i++;
         }else{
          set.add(s.charAt(j));
         } 
         j++;
      }
      max=Math.max(max,j-i);
      return max;
  }
}
*/

//tc:O(n): 2 pointer and map, SC:O(1)
class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
      int n=s.length();
      int max=0;
      int i=0;
      int j=0;
      Map<Character,Integer> map=new HashMap<>();
      while(j<n){
         if(map.containsKey(s.charAt(j))){
              max=Math.max(max,j-i);
              i=Math.max(i,map.get(s.charAt(j))+1);
         }
          map.put(s.charAt(j),j); 
         j++;
      }
      max=Math.max(max,j-i);
      return max;
  }
}
