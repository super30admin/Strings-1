//BruteForce : N*N*N
//HashSet : N*N - Beacuse i need to iterate once again through String and remove all the chars till the latest repeated char occurs.
class Solution {
    // Time Complexity : O(N) N: length of String
// Space Complexity : O(N)  HashMap -> worst case are chars all unique
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 HashMap:
 1. Use HashMap to store char and index of current pointer(fast).
 2. Update the slow pointer such that it is the start index of unique characters where fast pointer char is included.
 2. Calculate length based on fast and slow pointer and update the global result.
 */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s.length() == 0 || s == null) return result;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        int slow = 0; int fast = 0; 
        int n = s.length();
        while(fast<n){
            char c = s.charAt(fast);
            if(hm.containsKey(c)){
                slow = Math.max(slow, hm.get(c)+1);
            }
            hm.put(c,fast);
            result = Math.max(result,fast-slow+1);
            fast++;
        }
        return result; 
    }
}