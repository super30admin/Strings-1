// Time: O(n) where n is the length of str
// Space: O(1)

class Solution {
    public String customSortString(String order, String str) {
        if(str == null || str.length() == 0) return "";
        if(order == null || order.length() == 0) return str;
        
        StringBuilder result = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i< str.length(); i++){
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(int i=0; i<order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int val = map.get(c);
                while(val > 0){
                    result.append(c);
                    val--;
                }
                map.remove(c);
            }
        }
        
        for(char c: map.keySet()){
            int val = map.get(c);
            while(val > 0){
                    result.append(c);
                    val--;
                }
        }
        
        return result.toString();
    }
}