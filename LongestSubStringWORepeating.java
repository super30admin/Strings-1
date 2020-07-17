/**
 * Brute Force: n^3, n^2 and sliding windows(2n) - HashSet
 * Here, implementing HashMap (O(n)) n-length of the string s
 * Space: O(n) (but can have max of 26 characters so can be O(1))
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int slow=0,fast=0,maxlen=0;
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(hmap.containsKey(c)){
                slow = Math.max(slow,hmap.get(c));
            }
            hmap.put(c,fast+1);
            maxlen = Math.max(maxlen,fast-slow+1);
            fast++;
        }
        return maxlen;
    }
}