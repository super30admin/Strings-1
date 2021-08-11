class Solution {
    public String customSortString(String order, String s) {
        
        if(s == null || s.length() == 0 || order == null || order.length() == 0) {
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < order.length(); i++) {
            
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                while(count > 0) {
                    sb.append(ch);
                    count--;
                }

                map.remove(ch);
            }
        }
        
        for(Character ch : map.keySet()) {
            int count = map.get(ch);
            while(count > 0) {
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }
}

//Time : O(order.length + s.length)
//Space : O(s.length)