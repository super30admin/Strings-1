// Time Complexity: O(T)
// Space Complextity: O(T)
// Passed Leetcode

class Solution {
    public String customSortString(String S, String T) {
        
        if (S.length() == 0 || T.length() == 0) {
            return T;
        }

        
        LinkedHashMap<String, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++) {
            String curr = String.valueOf(S.charAt(i));
            map.put(curr, new int[] {i, 0});

        }
        
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < T.length(); i++) {
            String curr = String.valueOf(T.charAt(i));
            if (map.containsKey(curr)) {
                int[] vals = map.get(curr);
                vals[1] += 1;
            } else {
                sb.append(curr);
            }
        }
        
        for (Map.Entry<String, int[]> mapElement : map.entrySet()) { 
            
            for (int i = 0; i < mapElement.getValue()[1]; i++) {
                sb.append(mapElement.getKey());
            }
        }
        
        return sb.toString();
    }
}