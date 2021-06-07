import java.util.HashSet;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class longestWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        
        HashSet<Character>map=new HashSet<>();
        int maxCount=0;
        int i=0,j=0;
        
        while(j<s.length()){
            
            if(!map.contains(s.charAt(j))){
                map.add(s.charAt(j++));
                maxCount=Math.max(maxCount,map.size());
            }else{
                map.remove(s.charAt(i++));
            }
        }
        return maxCount;
    }
}
