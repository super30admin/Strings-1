// Time Complexity : 0(n)
// Space Complexity : 0(1) as we will have constant(26) space for map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        //hashmap for storing index+1 for a character
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0, slow = 0;
        //iterating through the string
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //update slow pointer
            if(map.containsKey(c))
                slow = Math.max(slow,map.get(c));
            //update index of character
            map.put(c,i+1);
            //update max
            max = Math.max(max,i-slow+1);
        }
        return max;
    }
}