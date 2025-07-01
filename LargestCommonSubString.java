// Time complexity - O(n)
// Space Complexity - O(1)
// Solved on leetcode - yes
// Faced any issues - No
// Creating a Hashmap to store the characters and it's index, If the character is not present we are adding to the map. else we are checking if that if after the occurance of left, then we update the max check and move the left to the latest occurance. else we can simple update the value in map of that character
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length(), left =0, right =0,max=0;
        for(char c:s.toCharArray()){
            if(!map.containsKey(c)) {
                map.put(c,right);
            } else {
                if(map.get(c)>=left) {
                    max = Math.max(max, right-left);
                    left = map.get(c)+1;
                }
                map.put(c,right);
            }
            right++;
        }
        return Math.max(max, right-left);
    }
}
