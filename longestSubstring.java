/**

s = "abcabcbb"

abc
bca
cab
abc
bc
cb
b
b

"wkew"
s = 1
e = 3

p 
w

result = 2

TC - O(2N) where N is the length of the string.
SC - O(W) where W is the window size.

**/


class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0)
        {
            return 0;
        }
        
        int start = 0;
        int end = 0;
        
        Set<Character> charSet = new HashSet<>();
        int result = Integer.MIN_VALUE;
        
        while (end < s.length())
        {
            char c = s.charAt(end);
            
            while(charSet.contains(c))
            {
                charSet.remove(s.charAt(start));
                start++;
            }
            
            charSet.add(c);
            result = Math.max(result, end - start + 1);
            end++;
        }
        
        return result;
    }
}
