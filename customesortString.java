//Time complexity=O(n)
//Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< T.length(); i++){
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while(cnt > 0){
                    sb.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char c = entry.getKey();
            int cnt = entry.getValue();
            while(cnt > 0){
                sb.append(c);
                cnt--;
            }
        }
        return sb.toString();
    }
}