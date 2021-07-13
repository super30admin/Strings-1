// Time Complexity : O(m+n)
// Space Complexity : O(26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String order, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        //store all character frequencies in str to map
        for(char c: str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //iterate over order
        for(int i= 0; i<order.length(); i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                while(map.get(ch)>0){
                    result.append(ch);
                    map.put(ch, map.get(ch)-1);
                }
                map.remove(ch);
            }
        }
        
        //iterate over map
        for(char c: map.keySet()){
            while(map.get(c) >0){
                result.append(c);
                map.put(c, map.get(c)-1);
            }
       
        }
        return result.toString();
    }
}