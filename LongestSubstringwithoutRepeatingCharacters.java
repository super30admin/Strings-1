//Time : O(n)
//Space: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int fast= 0 , slow =0;
        HashMap<Character, Integer> h = new HashMap<>();
         int max=0;
        while(fast<s.length())
        {   char c = s.charAt(fast);
            if(!h.containsKey(c))
            {
                h.put(c,fast);
            }
            else
            { max = Math.max(max, fast-slow);
              slow = Math.max(slow,h.get(c)+1);
              h.put(c, fast);
                
            }
         fast ++;
        }
        max = Math.max(fast-slow, max);
        
        return max;
    }
}