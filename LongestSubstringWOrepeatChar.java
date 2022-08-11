import java.util.HashSet;

//Time Complexity- O(n)
//Space Complexity- O(1)
//Sucessfully ran on leetcode

class Solution {
 public int lengthOfLongestSubstring(String s) {
     int i=0;
     int j=0;
     int max=0;
     
     HashSet<Character> hashSet = new HashSet();
     
     while(j<s.length()){
         
         if(!hashSet.contains(s.charAt(j))){
             hashSet.add(s.charAt(j));
             j++;
          max= Math.max(hashSet.size(), max);
         }
         
         else{
             
             hashSet.remove(s.charAt(i));
             i++;
         }
     }
     
     return max;
 }
}
