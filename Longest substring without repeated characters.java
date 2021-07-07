TC:O(n)
SC:O(n)

Runtime: 7 ms, faster than 82.52% of Java online submissions for Longest Substring Without Repeating Characters.

Approach: Maintaining a left and right pointer ,we traverse through string using a sliding window.Using a hashmap we store the index+1 of the elements as we traverse.
Whenever the right pointer finds a repeated character using the hashmap, it will bring the left pointer to the index value of the char from
the hashmap.We increase the right pointer till the string length and in each step we find the max length by taking the difference of right and left pointer.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0) return 0;
        int left =0;
        int right=0;
        int max=0;
        Map<Character,Integer> map = new HashMap<>();
       while(right< s.length()){
          if(map.containsKey(s.charAt(right))){
            left=Math.max(map.get(s.charAt(right)),left);
          } 
              map.put(s.charAt(right),right+1);
              max= Math.max(max,right-left+1);
              right++;
          }
       return max;
    }
}
