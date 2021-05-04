/**Leetcode Question 3 = Longest Substring Without Repeating characters */
/**Algorithm - Two Pointer/ Sliding window
 * Take the slow and fast pointer(i works as the fast pointer in the code)
 * Add the current element on the fast pointer in the Hashmap if it is not there with index+ 1 as the value
 * Value = Index + 1 because we want to put the slow pointer at the next position when the character is encountered again
 * Slow pointer is always moved ahead so if we encounter a value for incrementing slow less than its current position we don't change slow
 * Max = i - slow + 1  - length of the longest substring till now
 */
/**TC - O(N) - N is the length of the string
 * SC - O(N) - N is the length of the string - worst case scenario, all the letters are added to the hashmap
 */
public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            int slow =0;
            int max =0;
            for(int i =0; i< s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    slow = Math.max(map.get(c), slow);
                    map.put(c,i+1);
                }
                else{
                    map.put(c, i+1);
                }
                max = Math.max(max, (i - slow +1));
            }
            return max;
        }
    }
}
