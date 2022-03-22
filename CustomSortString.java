
//Time Complexity: 0(m+n)
//SPace:o(n)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i =0;i< s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0;i<order.length();i++)
        {
            Character curr = order.charAt(i);
            if(map.containsKey(curr))
            {
                int freq = map.get(curr);
                while(freq > 0)
                {
                   sb.append(curr);
                    map.put(curr, freq -1);
                    freq = freq-1;
                }
                map.remove(curr,0);
                
            }
        }
        
        for(Character ele : map.keySet())
        {
            int   count = map.get(ele);
            while(count!= 0)
            {
                 sb.append(ele);
                map.put(ele,count-1);
                count = count -1;
            }
            map.remove(ele,0);
           
        }
        
        return sb.toString();
        
    }
} c