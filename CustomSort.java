/*
 * Time complexity : O(m + n)
 * Space Complexity : O(m) where m is total number of characters in T
 */
class Solution {
    public String customSortString(String S, String T) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(Character ch : T.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        StringBuilder str = new StringBuilder();
        
        for(Character ch : S.toCharArray()){
            if(map.containsKey(ch)){
                
                int count = map.get(ch);
                
                while(count > 0){
                    str.append(ch);
                    count--;
                }
                
                map.remove(ch);
            }
        }
        
        for(Character ch : map.keySet()){
            
            int count = map.get(ch);
                
                while(count > 0){
                    str.append(ch);
                    count--;
                }
                
        }
        
        return str.toString();
        
    }
}