class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null)    return 0;
        int slow=0;
        int fast=0;
        int len=0;
        HashSet<Character> hs=new HashSet<>();
        while(s.length()>fast)
        {
            if(!hs.contains(s.charAt(fast)))
            {
                hs.add(s.charAt(fast));
                fast++;
                len=Math.max(hs.size(),len);
            }
            else
            {
                hs.remove(s.charAt(slow));
                slow++;
            }
        }
        return len;
        
    }
}