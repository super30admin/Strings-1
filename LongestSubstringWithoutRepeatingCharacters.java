/*
* Approach1: By using a set we can keep track of the repeating characters. 
* Once we encounter the repeating character, move the left pointer until we reach the first seen repeating character and also remove the characters from the set
* At every index, add the element to the set and calculate the size of the window as thats the longest substring without repeating character and compare it with the previous max. 
TC: O(2n) - two pointers iterating over the array. overall O(n)
SC: O(1) -> constant space as only 26 characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;

        for(int right = 0; right < len; right++){
            char ch = s.charAt(right);
            if(set.contains(ch)){
                // keep incrementing left pointer and removing characters until the left reaches the repeating character
                while(set.contains(ch)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            set.add(ch);
            // calculate the max length at each level
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}


/*
* Approach2: By using a map we can keep track of the repeating characters along with its index so we dont have to iterate over the string index by index but can use the stored index to reach the repeating character in O(1)
TC: O(n) - as we are iterating the string only once
SC: O(1) -> constant space as only 26 characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;

        for(int right = 0; right < len; right++){
            char ch = s.charAt(right);
            // if map contains key, we need to make sure left pointer is moved only if the index of the repeating character is greater than left, we cant go backwards, so taking the max of current left and store index of the repeating character
            if(map.containsKey(ch)){
                 left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            // calculate the max length at each level
            max = Math.max(max, right - left + 1);

           
        }
        return max;
    }
}