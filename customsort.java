// Time Complexity : O(m+n) m and n are the lenghts of order and s strings
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
traverse the s string and store the freq of each character in a hashmap. Traverse the order string and 
append the characters in their freq times to the stringbuilder.



class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),0);
            }
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<order.length();i++){
            if(map.containsKey(order.charAt(i))){
                while(map.get(order.charAt(i)) > 0){
                    map.put(order.charAt(i),map.get(order.charAt(i))-1);
                    result.append(order.charAt(i));
                }
                
            }
            
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) > 0){
                result.append(s.charAt(i));
            }
            
        }
        return result.toString();
        
        
    }
}