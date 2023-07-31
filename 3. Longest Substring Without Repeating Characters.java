// Time Complexity :  O(n) // length of the string
// Space Complexity : O(26) //constant
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we need a hashmap because abcdefbzyuhjkl is the string till f the longest sub string is 6 but at b we need to start the string from 
// the previous index of b +1 so we need to store index of the characters. 
// we iterate on the string and at each char we check if that char is present in the map. 
// if it present in the map then we place the slow pointer which is start of the substring at max of slow and the value we get from map
// and we insert the char into the map and update the max value.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int slow =0;
        int max= 0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(hmap.containsKey(c))
                slow = Math.max(slow, hmap.get(c)+1);
            hmap.put(c,i);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }
}