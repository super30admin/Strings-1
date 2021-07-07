// Time Complexity : O(2n) = O(n). n is the length of the string
// Space Complexity : O(1) Though we use hash set here which holds only 26 char at anypoint in time whihc is constant.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach
// Sliding window technique
// Set the start and end at begining and when there is a duplicate move the start till the duplicate elemer is removed
// Keep Track of max length so far at each steps.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;
        
        // start and end
        int start = 0; int end = 0;
        //set the hashset for identifying duplicates
        HashSet<Character> set  = new HashSet<Character>();
        // update max count
        int max_count = 0;
        while(end < s.length()){
            //If the char already available in the set
            while(set.contains(s.charAt(end)))
            {
                set.remove(s.charAt(start));
                start++;
            }  
         max_count = Math.max(max_count, end-start+1);
          
            // if not available in the set
           set.add(s.charAt(end));
            end++;
            }
        return max_count;
        }
    }
