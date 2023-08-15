// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Hashmap to store the character and it's index
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        //Go through all the characters in string and update start only when you fin a repeat occurence of a character
        for(int end=0; end<s.length(); end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                int i = map.get(c);
                if(i>=start){
                    start = i+1;
                    
                }
            }
            map.put(c,end);
            //Get the length using start and end
            length = Math.max(length, end-start+1);
        }

        return length;
    }
}