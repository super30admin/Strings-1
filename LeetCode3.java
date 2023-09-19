//Time Complexity :O(n)
//Space Complexity: O(1) // max of 256 chars
// Ran on leetcode

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max =0;
        int slow =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                slow = Math.max(slow, map.get(ch)+1);   
        // check whether the stored char encountered at slow and character present in hashmap are in substring
            }
            map.put(s.charAt(i),i); // update the index
            max= Math.max(max, i-slow+1); // check max at every point
        }
        return max;
    }
}