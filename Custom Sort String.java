// Time Complexity :O(M+N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<order.length();i++)
        {
            char c=order.charAt(i);
            if(map.containsKey(c))
            {
                int freq= map.get(c);
                for(int j=0;j<freq;j++)
                {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char key:map.keySet())
        {
            int freq=map.get(key);
            {
                for(int i=0;i<freq;i++)
                sb.append(key);
            }
        }
        return sb.toString();
    }
}