//Optimized sliding window  moving fast pointer forward and slow pointer is moved only occassionally 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int fast = 0 ; int slow = 0 ;
        HashMap<Character,Integer> map = new HashMap<>();
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
              //  slow = map.get(c);//slow pointer to map.get(c) position
               //slow pointer cannot move backwards hence take MAX of old slow position with max very important
                slow = Math.max(map.get(c),slow);
                // map.put(c,fast+1); // change the position to the latest repeated position
            }
            
            map.put(c,fast+1); // add the new charcter with position into map or update the latest position of repeated character 
           
            maxLength = Math.max(maxLength , fast-slow+1); //fast-slow +1 is the length of substring //between fast and slow window range
        fast++;
        }
        return maxLength;
    }
}

//Time complexity :O(n) ie length of String
//Space complexity : O(1) w6 characters max in hashmap