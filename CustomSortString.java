// Time Complexity : O(m+n) --> O(n) // n - length of T // m - Length of S -->is ignored because its max length is a constant of 26
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// https://leetcode.com/problems/custom-sort-string/
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<T.length();i++)
        {
            char c=T.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            if(map.containsKey(c))
            {
                int count=map.get(c);
                while(count>0)
                {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character,Integer> m:map.entrySet())
        {
            int count=m.getValue();
            while(count>0)
            {
              sb.append(m.getKey());
                count--;
            }
            
        }
        
        return sb.toString();
    }
}