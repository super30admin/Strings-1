class Solution {
    
    
    //Time Complexity: O(m + n)
    //Space Complexity: O(n)
    
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            
        }
        
        StringBuilder result = new StringBuilder(); //O(n)
        for(int i=0; i<order.length(); i++){
            
            char c = order.charAt(i);
            int freq = map.getOrDefault(c, 0);
            
            while(freq>0){
                result.append(c);
                freq--;
            }
            map.remove(c);
            
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            
            char c = entry.getKey();
            int freq = entry.getValue();
            
            while(freq>0){
                result.append(c);
                freq--;   
            }  
        }
        
        return result.toString();
    }
    
    
    
    
    
    //Time Complexity: O(m + nlog(n)) => O(n(log(n))), m = size of order, n = size of s
    //Space Complexity: O(1) , O(n) because of the sorting we need to store in a list
//     public String customSortString(String order, String s) {
        
//         Map<Character, Integer> map = new HashMap<>();
        
        
//         for(int i=0; i<order.length(); i++){
//             map.put(order.charAt(i), i+1);
//         }
        
//         List<Character> list = new ArrayList<>();
        
//         for(int i=0; i<s.length(); i++){
            
//             list.add(s.charAt(i));
//         }
        
//         Collections.sort(list, (a,b) -> { 
//             return map.getOrDefault(a, 0) - map.getOrDefault(b, 0);
//         });
        
//         String result = "";
//         for(int i=0; i<list.size(); i++){
//             result+= list.get(i);
//         }
        
//         return result;
        
//     }
}
