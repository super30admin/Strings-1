/*
  Time; O(n) n = length of s.
  Space O(1) max storing all lower case 26 chars.
  Run on LeetCode : yes.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;

        if(s.length() == 0)
            return ret;

        HashSet<Character> hset = new HashSet();
        int st = 0;
        int en = 0;

        //use sliding window.
        while(st < s.length() && en < s.length()){
            char ch = s.charAt(en);
            while(en < s.length() && !hset.contains(ch)){
                hset.add(ch);
                en++;
                if(en < s.length())
                    ch = s.charAt(en);
            }

            //cal height here because next we are decresing the len.
            //when decrementing st.
            ret = Math.max(ret, en-st);

            while(st < s.length() && hset.contains(ch)){
                hset.remove(s.charAt(st));
                st++;
            }
        }
        return ret;
    }
}
