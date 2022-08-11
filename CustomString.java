import java.util.HashMap;

//Time Complexity- O(m + n)
//Space Complexity- O(1)
//Sucessfully ran on leetcode

class Solution {
 public String customSortString(String order, String s) {
     if(order == null || order.length()==0) return s;
     
     HashMap<Character, Integer> map = new HashMap<>();
     
     for(int i=0 ; i< s.length(); i++){
         char c= s.charAt(i);
         
         map.put(c, map.getOrDefault(c,0) + 1);
     }
     
     StringBuilder sb= new StringBuilder();
     for(int i=0; i< order.length(); i++){
         
         char c= order.charAt(i);
         int cnt= 0;
         if(map.containsKey(c)){
             cnt= map.get(c);
             map.remove(c);
         }
         while(cnt>0){
             sb.append(c);
             cnt--;
         }   
     }
     for( char key : map.keySet()){
         int cnt= map.get(key);
         while(cnt>0){
         sb.append(key);
             cnt--;
         }
     }
     return sb.toString();
 }
}