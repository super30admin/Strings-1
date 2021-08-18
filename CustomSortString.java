//Time Complexity : O(max(m,n)), m -> Length of order, n -> Length of String 
// Space Complexity : O(n), n -> Length of StringBuilder
class Solution {
    public String customSortString(String order, String s) {
        if(s == null || s.length() == 0 || order == null || order.length() == 0) return s;
        
        Map<Character, Integer> countMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        
        for(int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            if(countMap.containsKey(ch)) {
                int count = countMap.get(ch);
                while(count>0) {
                    result.append(ch);
                    count--;
                }
                countMap.remove(ch);
            }
        }
        
        for(char key : countMap.keySet()) {
            int count = countMap.get(key);
            while(count>0) {
                result.append(key);
                count--;
            }
        }
        
        return result.toString();
    }
}