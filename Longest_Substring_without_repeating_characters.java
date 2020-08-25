import java.util.HashMap;

class Solution {
	//Approach: Sliding Window
	//1. Here I have used two pointers - slow and fast, slow moves when I face a repetition of character and fast will be used to iterated the string.
	//2. HashMap is used for storing the characters with their corresponding frequencies + 1. Because next time repetition occurs, we can use the index from map to directly move the slow pointer.
	//3. This way we keep moving through the string and every time we move fast we check adn update the max length.
	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s == null)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>(26);
        //map to hold characters from s and their corresponding position + 1
        int start = 0; int end = 0;
        int slow = 0, fast = 0;
        for(int i=0; i<s.length(); i++)
        {
            
            if(map.containsKey(s.charAt(i)))
            {
                slow = Math.max(slow, map.get(s.charAt(i)));
                
            }
            map.put(s.charAt(i), i+1);
            if(max < (fast - slow +1))
            {
                max = fast - slow +1;
                start = slow;
                end = fast;
            }
            fast++;
        }
        //To return the maximum length substring - used 2 pointers  - start and end, and move them when we are finding a new max to slow and fast correspondingly. 
        System.out.println("max substring is -- "+s.substring(start, end+1));
        return max;
    }
}

//Time Complexity : O(n) 
//Space Complexity : O(1) since we use hashmap of 26 entries
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :