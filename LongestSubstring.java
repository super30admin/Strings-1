/*
This solution uses two pointers combines with a Hash map. A slow pointer and fast pointer is used, where the fast pointer
will keep incrementing and adding elements to the map and their locations from the string, till a repeating element is found. 
The length of the the substring is noted, and then the slow pointer is bought to the location where the repeating element was
found, with the fast pointer continuing from the next element onwards. This cycle repeats till the longest substring is found.

Can also be solved using a Hash set in O(n) time, but with 2n time instead of n time

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(1) since the maximum size of the Hash map can only be 26
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
           
        int slow = 0;
        for(int i = 0; i < s.length(); i++)
        {   
            char c = s.charAt(i);
            if(map.containsKey(c))
            {   //If the current location of the slow pointer is ahead of the location of the last found instance of the repeating character,
                //The latest location is taken, so that we do not consider an innacurate substring that was already checked.
                slow = Math.max(map.get(c) + 1, slow);
            }
            
            count = Math.max(count, i - slow + 1);                
            map.put(c, i);

        }
        
        return count;
    }
}