class Solution {
//    Time complexity: O(N), n is the length of the order string
// Space Complexity: O(1) amortized as map would store maximum of 26 characters and their frequencies, even set would have 26 
    

    
    
    //     public String customSortString(String order, String s) {
      
//         Map<Character, Integer> map = new HashMap<>();
        
//         for(int i = 0 ; i < order.length() ; ++i)
//         {
//             map.put(order.charAt(i), i+1);
//         }
        
//         List<Character> list = new ArrayList<>();
//         for (int i = 0 ; i < s.length() ; ++i)
//         {
//             list.add(s.charAt(i));
//         }
        
//         Collections.sort(list , (a, b) -> {
//             return map.getOrDefault(a, 0)- map.getOrDefault(b,0);
//         });
        
//         StringBuilder sb = new StringBuilder();
//         for(int i =0 ; i < list.size(); ++i)
//         {
//             sb.append(list.get(i));
//         }
//         return sb.toString();
//     }
    
    
    public String customSortString(String order, String s) {
      
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i <s.length() ; i++)
        {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c, 0)+1);
        }
        
        StringBuilder res = new StringBuilder();
        
      
        for (int i = 0 ; i < order.length(); ++i)
        {
            char c = order.charAt(i);
            int freq = map.getOrDefault(c, 0);
            while(freq > 0)
            {
                res.append(c);
                --freq;
            }
            map.remove(c);
        }
        
        
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            char c = entry.getKey();
            int freq = entry.getValue();
            while(freq>0)
            {
                res.append(c);
                --freq;
            }
        }
        
        return res.toString();
    }
    
    
}
