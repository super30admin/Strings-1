// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public String customSortString(String S, String T) {
         StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < T.length();i++)
        {
            mp.put(T.charAt(i), mp.getOrDefault(T.charAt(i),0)+1);
        }
        for(Character c:S.toCharArray())
        {
            if(mp.containsKey(c))
            {
                for(int i = 0 ; i < mp.get(c);i++)
                {
                    sb.append(c);
                }
            }
            mp.remove(c);
        }
    
        for(Map.Entry<Character,Integer> e:mp.entrySet())
        {
            for(int i = 0 ; i <e.getValue();i++)
            {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}