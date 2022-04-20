class CustomSort {
  /**
   Time Complexity: O(n + m)
    n -> Order length
    m -> s.length
    
    Space Complexity: O(26) ~~ O(1)
    
    Were you able to solve this on leetcode? yes
    */
    public String customSortString(String order, String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            set.add(c);
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            } else {
                result.append(c);
            }
        }
        
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(charCounts.containsKey(c)){
                int count = charCounts.get(c);
                for(int j = 0; j < count; j++){
                    result.append(c);
                }
            } 
        }
        
        return result.toString();
    }
}