// Time Complexity - O(Max(n,m)) where n and m is the length of the input strings
// Space Complexity - O(Max(n,m)) where n and m is the length of the input strings

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char i : order.toCharArray()){
            if(map.containsKey(i)){
                int freq = map.get(i);
                while(freq > 0){
                    sb.append(i);
                    freq--;
                }
                map.remove(i);
            }
        }
        
        for(char i : map.keySet()){
            int freq = map.get(i);
            while(freq > 0){
                sb.append(i);
                freq--;
            }
        }
        
        return sb.toString();
    }
}