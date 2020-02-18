//TC - O(n)
//SC - O(1) - worst case there are 26 characters in the hashset
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        
        Set<Character> st = new HashSet<>();
        
        int winS = 0, winE = 0, winL = 0;
        
        int max_len = 0;
        
        while(winE < s.length())
        {
            if(!st.contains(s.charAt(winE)))
            {
                st.add(s.charAt(winE));
                ++winE;
                ++winL;
            }
            else
            {
                if(winL > max_len)
                    max_len = winL;
                
                st.remove(s.charAt(winS));
                ++winS;
                --winL;
            }
        }
        
        if(winL > max_len)
            max_len = winL;
        
        return max_len;
    }
}
