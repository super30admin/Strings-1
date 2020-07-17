// Time Complexity : O(m + n) where m is the length of the string S and n is the length of the string T
// Space Complexity : O(1) 

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: T.toCharArray()) {
           map.put(c, map.getOrDefault(c, 0) + 1); 
        }
         
        StringBuilder sb = new StringBuilder(); 
        for(char c: S.toCharArray()) {             
            while(map.containsKey(c)) {
                int val = map.get(c);
                if(val == 0)
                    map.remove(c);
                else {
                    sb.append(c);
                    map.put(c, val - 1);
                }
            }
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            while(val != 0) {
                sb.append(entry.getKey());
                val--;
            }
        }
        return sb.toString();
    }
}