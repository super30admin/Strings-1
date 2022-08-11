// TC : O(m+n)
// SC : O(1)

class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length()==0) return s;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
                
            }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            int count=0;
            if(map.containsKey(c)){
            count = map.get(c);
            map.remove(c);
            }
            
            while(count>0){
                sb.append(c);
                count--;    
            }
        }
        
        for(char key:map.keySet()){
            int count=0;
            count = map.get(key);
            while(count>0){
                sb.append(key);
                count--;    
            }
        }
        return sb.toString();
    }
}