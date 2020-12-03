// Time Complexity : O(n), where n is the length of the string
// Space Complexity :O(1), at max we will store 26 characters in the hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain english
//1. Create a hashMap to store non-repeating characters in a subString along with index+1 as value. Create 2 pointer slow and fast 
        //both starting at 0
//2. start moving the fast pointer, while adding all the unique characters in the hashMap with its value as index+1, those come in 
        //between slow and fast pointer and keep updating the max with the hashMap's size
//3. if fast encounter duplicate character, get the index of the duplicate value from the hashMap and increment the slow pointer till
        // that index, removing all the characters from the hashMap that slow encounters in the given String input 
        //Return the max in the End
        
        
// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //edge case
        //if(s.length() == 0) return 0;
        int max =0;
        //hashMap to store the non repeating characters in the hashMap with their index +1
        HashMap<Character, Integer> hMap = new HashMap<>();
        int slow = 0;
        int fast = 0;
        while(slow < s.length() && fast < s.length()){
            char c = s.charAt(fast);
            //check if the character is already present in the hashMap
            if(hMap.containsKey(c)){
                int end = hMap.get(c);
                //remove all the characters from slow pointer to where the previous duplicate is
                while(slow < end){
                    hMap.remove(s.charAt(slow));
                    slow++;
                }
            }
            //add the character with value as index+1
            hMap.put(c, fast+1);
            fast++;
            //update max
            max = Math.max(max, hMap.size());
        }
        return max;
    }
}