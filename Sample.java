//Problem1 
//Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
// Time Complexity : O(m+n) map's and appending iternation
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), ++count);
            }
            else
                map.put(s.charAt(i),1);
        }
        
        for(int i=0;i<order.length();i++)
        {   
            if(map.containsKey(order.charAt(i)))
            {
                int count = map.get(order.charAt(i));
                for(int j=0;j<count;j++)
                {
                    result.append(order.charAt(i));
                }
                map.remove(order.charAt(i));
            }
        }

        for(char c: map.keySet())
        {   
            int count = map.get(c);
            for(int j=0;j<count;j++)
            {
                result.append(c);
            }
        }

        return result.toString();
        
    }
}

//Problem2 
//Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow=0;
        int max =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                slow = Math.max(slow, map.get(c) + 1);
            }
            max = Math.max(max, i-slow+1); // fast-slow+1
            map.put(c, i);
        }
        return max;
    }
}
