// Time Complexity : O(s.length + t.length)
// Space Complexity : O(t.length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }
        System.out.print(map);
        for(int i = 0; i < order.length(); i++){
            if(map.containsKey(order.charAt(i))){
                while(map.get(order.charAt(i)) != 0){
                    result.append(order.charAt(i));
                    map.put(order.charAt(i), map.get(order.charAt(i))-1);
                }
                map.remove(order.charAt(i));
            }   
        }
        for(HashMap.Entry<Character, Integer> entry: map.entrySet()){
            char c = entry.getKey();
            while(entry.getValue() != 0 ){
                result.append(c);
                map.put(c, entry.getValue() - 1);
            }
        }
        
        return result.toString(); 
        
        
    }
}