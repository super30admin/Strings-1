// TC : O(n) - s.length() 
// SC : O(n) - s.length()

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        if(order == null || order.length() == 0 || s == null || s.length() == 0)
            return result.toString();
        
        HashMap<Character, Integer> hMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!hMap.containsKey(c))
                hMap.put(c, 0);
            hMap.put(c, hMap.get(c)+1);
        }
        
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(hMap.containsKey(c)) {
                int k = hMap.get(c);
                hMap.put(c, 0);
                for(int j = 0; j < k; j++)
                    result.append(c);
            }
        }
        
        for(Map.Entry<Character, Integer> ele : hMap.entrySet()) {
            char c = ele.getKey();
            int val = ele.getValue();
            for(int i = 0; i < val; i++)
                result.append(c);
        }
        return result.toString();
    }
}
