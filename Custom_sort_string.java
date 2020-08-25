import java.util.HashMap;

//Approach: Using HashMap
//1. Iterate over T and put the frequencies and characters in map
//2. Then iterate over S and start building the string if the corresponding character is in the map thereby removing the characters when we have added them all to string builder. 
//3. Finally add the remaining characters which are not in S but in T to the string builder.
class Solution {
    public String customSortString(String S, String T) {
        if(S == null && T == null)
        {
            return null;
        }
        StringBuilder str = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i < T.length(); i++)
        {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0)+1);
        }
        for(int i=0; i < S.length(); i++)
        {
            if(map.containsKey(S.charAt(i)))
            {
                int val = map.get(S.charAt(i));
                while(val > 0)
                {
                    str.append(S.charAt(i));
                    val --;
                    map.put(S.charAt(i), val);
                    map.remove(S.charAt(i), 0);
                }
            }
        }
        for(char ch: map.keySet())
        {
            int val = map.get(ch);
            while(val > 0)
            {
                str.append(ch);
                val --;
            }                                
        }
        return str.toString();
    }
}

//Time Complexity : O(n) 
//Space Complexity : O(1) since we use hashmap of 26 entries
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :