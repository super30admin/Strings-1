//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public String customSortString(String order, String str) {
        
        if(order.length() == 0 || str.length() == 0){
            
            return "";
        }
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map1 = new HashMap<>();
        
        for(int i = 0; i < str.length(); i ++){
            
            char ch = str.charAt(i);
            
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
       // System.out.println(map1);
        for(int i = 0; i < order.length(); i ++){
            
            char ch = order.charAt(i);
            
            if(map1.containsKey(ch)){
                
                int temp = map1.get(ch);
                while(temp != 0){
                    
                    result.append(ch);
                    temp --;
                }
                map1.remove(ch);
            }
        }
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){//for(char ch : map1.keySet())
            
            char ch = entry.getKey();
            int temp = entry.getValue();
            while(temp != 0){
                    
                    result.append(ch);
                    temp --;
                }
         //   map1.remove(ch);
        }
        
        return result.toString();
    }
}