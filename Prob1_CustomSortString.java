// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        //Storing string s into HashMap
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < order.length(); i++){ 
            char ch = order.charAt(i); 
            if(map.containsKey(ch)){ // Getting count of each Character from Order String
                int count = map.get(ch);
                while(count-- > 0){
                    result.append(ch); // Appending character that count of times
                }
                map.remove(ch);
            }
        }
        
        for(Character c : map.keySet()){//Adding remaining character which are not in order but in S
            int count = map.get(c);
            
            while(count-- > 0){
                result.append(c);
            }
        }
        
        
        return result.toString();
        
    }
}