// Time Complexity: O(n)
// Space Complexity: O(1)

/*
 * we keep track of all characters in the string and if we encounter
 * the same character in the string we increment the left pointer until
 * that value is no longer in the hashmap.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(!map.contains(s.charAt(i))){
                map.add(s.charAt(i));
            }
            else{
                while(s.charAt(left) != s.charAt(i)){
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            maxLength = Math.max(maxLength, i-left+1);
        }
        return maxLength;
    }
}