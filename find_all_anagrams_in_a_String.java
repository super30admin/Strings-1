// Time Complexity : O(n), where n is the length of string s
// Space Complexity :O(1), hashMap will atmost have 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner Explanation of your code in plain English
//1. Create a hashMap and put all the characters from string p with their frequency in the hashMap. Start slow and fast pointers from 
        //0 index moving only fast (checking if the character at fast exists in hashMap, get its frequency & reduce by 1 and if the 
        //frequency of the character becomes 0, that means the incoming character is required character, so increase the match by 1)
        //till the window size between slow and fast is equal to the length of string p
//2. once the window size is reached, along with fast check above, check if character at slow exists in the hashMap, get its 
        //frequency and increase by 1. If frequency becomes 1 meaning the outgoing character is taking away a required character 
        //so reduce the match by 1
//3. In each Iteration check if match is equal to the hashMap size, meaning all the characters in the String p have been found in 
        //the substring in String s (anagram) between slow and fast pointer, so add slow index to the result
        //Return the result

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //result to be returned
        List<Integer> result = new ArrayList<>();
        //edge case
        if(s.length() == 0 && p.length() == 0) return result;
        
        //hashMap to store all the unique characters of string p with frequency
        HashMap<Character, Integer> hMap = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            hMap.put(c, hMap.getOrDefault(c, 0) +1);
        }
        
        int slow = 0;
        int fast = 0;
        //to check if the subString in string s under consideration has all the characters from p
        int match = 0;
        while(slow < s.length() && fast < s.length()){
            if(fast - slow +1 > p.length()){
                //outgoing charcter
                char outChar = s.charAt(slow);
                if(hMap.containsKey(outChar)){
                    int outCount = hMap.get(outChar);
                    outCount++;
                    if(outCount == 1) match--;
                    hMap.put(outChar, outCount);
                }
                slow++;
            }
            //move the fast pointer
            //incoming charcter
            char inChar = s.charAt(fast);
            if(hMap.containsKey(inChar)){
                int inCount = hMap.get(inChar);
                inCount--;
                if(inCount == 0) match++;
                hMap.put(inChar, inCount);
            }
            fast++;
            
            //you find anagram, i.e match becomes equal to hashMap size
            if(match == hMap.size()){
                result.add(slow);
            }
        }
        return result;
    }
}