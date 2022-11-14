class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0) return 0;
        
        int max=-1;
        
        HashMap<Character,Integer> map=new HashMap<>();
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(map.containsKey(c))
                j=Math.max(j,map.get(c));
            map.put(c,i+1);
            max=Math.max(max,i-j+1);
        }
        
        return max;
        
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no