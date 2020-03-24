class Solution {
    public int lengthOfLongestSubstring(String s) {
        // base case
        if(s == null || s.length() == 0)
            return 0;
        
        int i=0, j=0, max=0;
        Set<Character> set = new HashSet<>();
        
        while(i<s.length() && j<s.length())
        {
                if(!set.contains(s.charAt(j)))
                {
                    set.add(s.charAt(j++));
                    max = Math.max(max, j-i);
                }
                else
                    set.remove(s.charAt(i++));
        }
        return max;
    }
}