class Solution {
    public String customSortString(String order, String s) {
        //create a freq map of s 
        //just go over the order string and keep on appending the current character to the output string, reduce the count in freq map. 
        
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            
            
        }
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < order.length(); i++){
            
            char c = order.charAt(i);
            if(freq.containsKey(c)){
                
                int count = freq.get(c);
                
                while(count > 0){
                    res.append(c);
                    count --;
                }
                
                freq.remove(c);
                
            }
            
        }
        
        //if there are any elements left in the map then append them to the list.
        
        if(!freq.isEmpty()){
            
            for(Map.Entry<Character, Integer> e : freq.entrySet()){
                
                int count = e.getValue();
                char c = e.getKey();
                
                while(count > 0){
                    res.append(c);
                    count --;
                }
                
            }
            
        }
        
        return res.toString();
    }
}