// Time Complexity : O(m + n) m is len of S and n is len of T
// Space Complexity : O(n) n is len of T the final o/p str len.
// Did this code successfully run on Leetcode : Yes

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char c = entry.getKey();
            int count = entry.getValue();
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}