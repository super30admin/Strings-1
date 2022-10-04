class Solution {
    //tc - o(2n)=>o(n)
    //sc-o(1)
    public int lengthOfLongestSubstring(String s) {
        //null case
        if(s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        int slow =0;
        int fast = 1;
        int max =0;
        set.add(s.charAt(0));
        while(fast < s.length())
        {
            char c = s.charAt(fast);
            if(set.contains(c))
            {
                //move slow pointer till c
                while(s.charAt(slow) != c)
                {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            max = Math.max(max, fast-slow+1);
            set.add(c);
            fast++;
        }
        return max;
    }
}