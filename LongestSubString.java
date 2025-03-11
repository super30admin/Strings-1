class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
        {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int slow=0;
        int maxLength=0;
        int n= s.length();
        for(int i=0;i<n;i++)
        {
            char ch =s.charAt(i);
          
                
                while(set.contains(ch))
                {
                    set.remove(s.charAt(slow));
                    slow++;
                }
            
            
                set.add(ch);
            
            maxLength = Math.max(maxLength, i-slow+1);
        }
        return maxLength;
    }
}

//tc: O(n)

//sc: O(1)