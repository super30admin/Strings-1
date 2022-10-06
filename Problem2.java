// Time Complexity : O(N)  (O(N+ N))
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

/***
 * We are maintaining a slow and a fast pointer . Moving the slow pointer if we encounter a repeated a character.
 * Also keeping a count of the max substring without repitition.
 */
class Problem2 {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int slow =0;

        int max = 0;

        for(int i =0; i<s.length(); i++){

            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }

            max = Math.max(max, i-slow+1);
            map.put(c, i+1);
        }
        return max;


    }
}