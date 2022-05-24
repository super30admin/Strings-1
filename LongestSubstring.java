class Solution {

    //Time Complexity: 0( n) where n is the length of the string
    //Space Complexity: 0(1)    //as there are only 26 characters to deal with hence only 26 character can go inside the hashmap
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    public int lengthOfLongestSubstring(String s) {
        HashMap <Character, Integer> map = new HashMap<>(); //we take a hashmap to store the character in string and their index + 1 to signify the next position after their occurence. The hashmap will get updated with the a new index if a letter is encountered 2nd time
        int slow = 0;   //we take a slow pointer to record the beginning position of the substring
        int max = 0;    //max to compare the previous substring and new and store the longest

        for(int fast = 0; fast < s.length(); fast++){//declaring a fast pointer to traverse through the string and also to capture the end of substring
            char c = s.charAt(fast);    //extracting one character at a time
            if(map.containsKey(c)){ //if map contains the character means our slow pointer should be pointed to that
                slow = Math.max(slow, map.get(c));//we are taking max slow as slow cannot move backward as in the previous tested window, there exists a duplicate
            }
            max = Math.max(max, fast-slow+1);//subtracting the indices of slow and fast and storing the max count in max
            map.put(c, fast+1); //if the character is not present in hashmap, then storing the character along with its next index. If it is present, then updating the character's index to the new found index
        }
        return max;
    }
}