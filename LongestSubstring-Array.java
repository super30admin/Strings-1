/*Time Complexity : O(1)
Space Complexity : O(n) 
Did it run on LeetCode : Yes.
Any problems : No.
*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int array[] = new int[256]; //Since array size is fixed, time complexity 
                                    //is O(1) and not O(n).
        int slow =0;
        int fast =0; 
          
        int max=0;
        
        while(fast<s.length())
        {  
            if(array[s.charAt(fast)]>0) //If a repeat element occurs.
                slow=Math.max(slow,array[s.charAt(fast)]);
            
            array[s.charAt(fast)]=fast+1;
            max = Math.max(max,fast-slow+1);
            fast++;
        }
        
        
        return max;
        
    }
}