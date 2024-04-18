## Problem1 
// Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity : O(n)
// Space Complexity : 0(1) 
// Did this code successfully run on Leetcode : yes

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        String res="";
        for(int i=0;i<order.length();i++)
        {
            if(map.containsKey(order.charAt(i)))
            {
                for(int j=0;j<map.get(order.charAt(i));j++)
                    res+=order.charAt(i);
                map.remove(order.charAt(i));
            }
        }
        for(char ch:map.keySet())
        {
            for(int j=0;j<map.get(ch);j++)
                    res+=ch;
        }
    return res;   
    }
}

## Problem2 

// Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

// Time Complexity : O(n)
// Space Complexity : 0(1) 
// Did this code successfully run on Leetcode : yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb=new StringBuilder();
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            String ch=Character.toString(s.charAt(i));
            if(sb.indexOf(ch)>-1)
            {
                sb.delete(0,sb.indexOf(ch)+1);
            }
            sb.append(ch);
            max=Math.max(max,sb.length());
        }
        return max; 
    }
}
