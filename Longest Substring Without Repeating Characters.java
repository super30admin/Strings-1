// Time Complexity : O(n), length of s
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int lengthOfLongestSubstring(String s) {
        //check for empty case
        if(s.length() == 0) return 0;
        //create a map to add occurance of letters and their position
        //so when we encounter a char already present in map
        //we move start to the next position from the position where we
        //encountered the char repeating
        //we update the last position of the chars position 
        HashMap<Character, Integer> map = new HashMap<>();
        //initially start and end is at first char and maxlen is 0
        int start = 0;
        int end = 0;
        int maxlen = 0;
        //we loop till end reaches last char
        //till repeat is encountered
        //we fix start and move end and find len of largest string possible
        while(end < s.length()){
            char c = s.charAt(end);
            //if we encounter a repeat char
            if(map.containsKey(c)) {
                //we move start to map.get+1 
                //(next position from where char was previouly found)
                //sometimes slow is passed the position 
                //(some other chars repeat was encountered before)
                //so we move start to max of start and the position
                //eg : abrstcdefchij-b-tu
                //when we encounter b, start is already at d (6th pos) (c repeat found)
                //so we cant move start backward (to r), so we choose the max out of the two
                start = Math.max(start, map.get(c)+1);
            }
            //we add the chars position in the map
            map.put(c, end);
            //we compare (prev maxlen vs curr string len (end-start+1)) and update maxlen 
            maxlen = Math.max(maxlen, end-start+1);
            //and inc end
            end++;
        } return maxlen; //return the final maxlen
    }
}

