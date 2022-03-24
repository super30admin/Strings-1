/**

TC - O(M) + O(N) where M is the length of order string and N
is the length of other string.
SC - O(N)


**/
class Solution {
    public String customSortString(String order, String s) {
        
        final Map<Character, Integer> charToFrequency = new HashMap<>();
        
        for (int i=0; i<s.length(); i++)
        {
            charToFrequency.put(s.charAt(i), charToFrequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
   
        for (int j=0; j<order.length(); j++)
        {
            if (charToFrequency.containsKey(order.charAt(j)))
            {
                int freq = charToFrequency.get(order.charAt(j));
                
                while (freq > 0)
                {
                    sb.append(order.charAt(j));
                    freq--;
                }
                
                charToFrequency.remove(order.charAt(j));
            }
        }
        
        for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet())
        {
            int value = entry.getValue();
            
            while(value > 0)
            {
                sb.append(entry.getKey());
                value--;
            }
        }
        
        return sb.toString();
    }
}
