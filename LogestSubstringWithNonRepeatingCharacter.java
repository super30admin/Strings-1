i/*

//Brute force- 
1. iterate through all the possible substrings of the given string s and call funtion allUnique. In that we can check if all chars in the substrings are unique. 
If this returns true then we store the length of this string.

//hashset and sliding window.
1.While iterating over the string if current char is not in the set I will slide the end pointer
to the right. untill s[end] is not in the hashset.
2. this substring is the substring with non repeating characters. We check the length of this substring and then if this is less than maxLen we would update the maxlen.
3. then keep removing the chars from the set till we can insert the cur char in the set as we need to start new window from cur char and need to check if O find another substring with non repeating characters with max len than cur max.
time - O(2n) = O(n) where n is no of chars in the string
space- O(min(m,n)) = size of set at any time. 
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int start = 0, end =0, maxLen = 0;
        //I would be using hashset to store the characters in the current window. 
        Set<Character>set = new HashSet<>();
        while(end < len){
            /*While iterating over the string if current char is not in the set I will slide the end pointer
            to the right. untill s[end] is not in the hashset. */
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end++));
                //calculate the len of current string with non repeating character
                maxLen = (maxLen < end-start) ? end-start : maxLen;
            }
            //else remove 1 char from the start from the cur window & check again if I will be able to insert 
            //the current character.
            else
                set.remove(s.charAt(start++));
        }
        return maxLen;
    }
}
