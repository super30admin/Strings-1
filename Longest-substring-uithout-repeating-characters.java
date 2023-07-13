// Time Complexity :o(n)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow =0;
        int max =0;
        //iterating through the string and storing the index of each character in the map
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                //if the character is already present in the map, update the slow pointer to the max of slow and the index of the character in the map
                slow = Math.max(slow, map.get(c)+1);
            } 
            map.put(c,i);
            max= Math.max(max,i-slow+1);
            //System.out.println(i+ "-"+ slow +"-"+ max );
        }
        return max;
    }
}
