/*Running Time Complexity: O(n)
Space Time Complexity: constant 
Sucessfully Run and Compiled on leetcode
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        int slow = 0; int fast = 0;
        int longest = 0;
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(hmap.containsKey(c)){
                slow = Math.max(slow,hmap.get(c));   
                }
    
            hmap.put(c,fast+1);
            longest = Math.max(longest,fast-slow+1);
            fast++;
            
            
        }
     return longest;   
    }
}