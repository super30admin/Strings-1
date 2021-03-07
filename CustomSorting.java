
/**
Time complexity : O(len(S) + len(T))

Space complexity : O(len(T))

**/
class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap();
        
        for(char c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        StringBuilder  sb = new StringBuilder();
        for(char c:S.toCharArray()) {
            if(map.containsKey(c)) {
               int count = map.get(c);
                while(count-->0) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        
        
        for(Character ch : map.keySet()) {
            int count = map.get(ch);
            while(count-->0) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
        
    }
}
