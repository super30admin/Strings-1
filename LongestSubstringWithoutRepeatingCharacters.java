/**
 * TC: O(n) sliding window on input string
 * SC: O(1) linited possibilites of characters in HashMap
 * Approach:
    Brute force: Generate all substrings, check for the one which does not have repeating characters and remember the maximum length
    Optimizied: Use a sliding window on the input string, remembering the last occurence of each charatcer in a HashMap
    Increase one end of the sliding window as long as there in no repeating character in that window, remembering the maxLength
    If you find a repeating character then shrink the window by moving the start pointer ahead
    While moving the start pointer ahead, ensure that we move it ahead: Math.max(start, map.get(ch) + 1)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // edge case
        if(s == null || s.length() < 1) {
            return 0;
        }
        
        int maxLength = -1, start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<String> resultantStrings = new ArrayList<>();
        
        // check until a valid window exists
        while(end < s.length()) {
            char ch = s.charAt(end);
            
            // check for repeating character in current window. if yes then shrink the window by moving start ahead
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch) + 1);
            }
            
            // update the map with character and its occurence at the end of the sliding window
            map.put(ch, end);
            // calculate current window length
            int currentLength = end - start + 1;
            
            /* To print the longest substrings 
            if(currentLength > maxLength) {
                resultantStrings = new ArrayList<>();
                resultantStrings.add(s.substring(start, end + 1));
            }
            else if(currentLength == maxLength){
                resultantStrings.add(s.substring(start, end + 1));
            }
            */
            
            // remember max length
            maxLength = Math.max(maxLength, currentLength);
            
            // move end of the window forward
            end++;
        }
        
        //System.out.println(resultantStrings);
        
        return maxLength;
        
    }
}
