// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //check for edge
        if(s == null || s.length() == 0) return 0;
        //create a Hashmap to hold character
        HashMap<Character, Integer> hash = new HashMap<>();
        //set a low pointer
        int slow = 0;
        //set a max to count max length 
        int max = 0;
        //start a for loop to go throuhg the string
        for(int i = 0; i < s.length(); i ++){
            //hold each letter
            char c = s.charAt(i);
            //check if the hash contains key
            if(hash.containsKey(c)){
                //set the slow to the max between either the current new slow or the one in the hash
                slow = Math.max(slow, hash.get(c));
            }
            //change the max either the current max or the current slow plus 1 - the ith index
            max = Math.max(max, i - slow + 1);
            //put the letter in the hash with a pointer
            hash.put(c, i+1);
        }
        //return the max;
        return max;
    }
}