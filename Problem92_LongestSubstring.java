//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //to store the indices of the occured character
        HashMap<Character, Integer> map = new HashMap<>();
        int start=0, end=0;
        int maxString = 0;
        int n = s.length();
        //till end reaches the end of string
        for(start=0,end=0; end<n; end++){
            //if the character is present in the map
            //update start to the hashmap value for the key
            //compare start with hashmap value to avoid start to iterate backward
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start, map.get(s.charAt(end)));
            }
            //get the length of max string
            maxString = Math.max(maxString, end-start+1);
            map.put(s.charAt(end), end+1);
        }
        return maxString;
    }
}