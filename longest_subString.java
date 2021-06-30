//LeetCode: All testcases passed
//Time Complexity: O(n), where n is the length of given string s
//Spavce Complexity: O(k), k is the number of unique characters in string s
/* Approach:
-> Used a hahsSet to maintain a list of unique characters
-> Used sliding window approach
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0,j=0,maxLen=0;
        while(i<s.length()&&j<s.length()){
            Character c = s.charAt(j);
            /*everytime I insert any character to the hashSet, I check if it is already there*/
            if(!set.contains(c)){
            set.add(s.charAt(j++));
            //Uisng DP: to calculate the maximum length
            maxLen = Math.max(maxLen,j-i);
            }
            else{
                //If the character is already present, then we increment i, i.e. we push the window forward.
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }
}
