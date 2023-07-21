/*
Time Complexity: O(n)
Space Complexity: O(k) - length opf longest substring.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        if(s.size()==1) 
            return 1;
        
        vector<int> mymap(256,-1);
        
        int l=0,r=0,len =0;
        
        while(r<s.size())
        {
            if(mymap[s[r]] != -1) l = max(mymap[s[r]]+1,l);
            
            mymap[s[r]] = r;
            
            len= max(len, r-l+1);
            r++;
        }
        
        return len;
    }
};