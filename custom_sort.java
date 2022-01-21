// Time Complexity : O(m+n) or O(max(m, n)) Traversing both strings (order and s)  
// Space Complexity : O(1) [Hashmap : 26 characters in hashmap at max]
class Solution {
    public String customSortString(String order, String s) {
        
        
        if (s == null){
            return s;
        }
        
        HashMap <Character, Integer> map = new HashMap<>();
        
        String result = "";
        
        // Key - character and value -count
        for (int i = 0; i < s.length() ; i++){
            
            char c = s.charAt(i);
            
            if (!map.containsKey(c)){
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
            
            
        }
        
        
        // Iterate through order and update the result as per the priority
        for (int i = 0; i < order.length() ; i++) {
            
            char c = order.charAt(i);
              
            
            if (map.containsKey(order.charAt(i))) {
                
                for ( int j = 0; j < map.get(order.charAt(i)); j++){
                
                    result = result + c;
                }
            
                // after updating in the result : remove the values from the hashmap
                map.remove(order.charAt(i));
 
            }
                      
        }
        
        
        // left out values in hashmap
        // Iterate through each key in the hashmap
        for (Map.Entry <Character, Integer> entry : map.entrySet()) {
            
            char c = entry.getKey();
                       
            for ( int j = 0; j < entry.getValue(); j++){
                
                result = result + c;
            }
            
            
        }
        
        
        return result;
    }
}