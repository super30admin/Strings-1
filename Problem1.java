// Time: O(m+n) length of both string
// Space: O(n)

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0 ; i< order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int freq = map.get(c);
                while(freq>0){
                    sb.append(c);
                    freq--;
                }
                map.put(c,0);
            }
        }
        for(Map.Entry<Character, Integer> set : map.entrySet()){
            char c = set.getKey();
            int freq = set.getValue();
            if(freq>0){
                while(freq>0){
                    sb.append(c);
                    freq--;
                }
            }
        }
        return sb.toString();
        
    }
}