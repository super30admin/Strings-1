// Time - O(S.length + T.length)
// Space - O(1)

class Solution {
    public String customSortString(String S, String T) {
        
        if(S == null || S.length() == 0 || T == null || T.length() == 0) {
            return T;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<T.length();i++) {
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(int i=0;i<S.length();i++) {
            char ch = S.charAt(i);
            if(map.containsKey(ch)) {
                for(int j=0;j<map.get(ch);j++) {
                    result.append(ch);                    
                }
                map.remove(ch);
            }
        }
        
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            for(int j=0;j<map.get(ch);j++) {
                result.append(ch);                    
            }               
        }
        
        
        return result.toString();
        
    }
}
