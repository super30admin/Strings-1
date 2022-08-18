// Time Complexity : o(n) 
// Space Complexity : o(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int slow=0;
        int fast=0;
        int count=0;
        int max=0;
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(!map.containsKey(c)){
                map.put(c,fast);
                count++;
              
                max=Math.max(count,max);
            }else{
                int index=map.get(c);
                   map.put(c,fast);
               
                if(slow>index){
                   
                    count++;
                    max=Math.max(count,max);
                  
                }else{
                    slow=index+1;
                    count=fast-slow+1;
                }
              
            }
            fast++;
        }
        return max;
    }
}