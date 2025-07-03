/*
 * TC: O(n) where n: s.length
 * SC: O(26) 26 character in alphabets which would be max length of HashMap.
 * 
 * Approach: Implemented using Sliding window. Iterate through the s string and at each iteration i will check if the char was already seen or not using a hashmap. and keep on adding or updating the index of the char in the map. also if i find any character repeated then i just assign my start pointer 
 * to the index of the repeated character's index from the map. keep updating answer on each iteration.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int startWindow = 0;
        int answer = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.length() == 0) return 0;

        for(int endWindow = 0; endWindow < s.length(); endWindow++){
            char ch = s.charAt(endWindow);

            if(map.containsKey(ch) && startWindow < map.get(ch)+1)
            startWindow = map.get(ch)+1;
                
        map.put(ch,endWindow);
        answer = Math.max(answer, endWindow - startWindow + 1);
        }
    return answer;   
    }
}