// Problem-1: Custom sort
/**
Iterative solution. Store the frequencies of String T in the map. Iterate over the S string and append the common characters in that order and frequency that appears in the map. 
TC = O(n) where n is the len of T string. 
SC = O(1) since thre can be only 26 chars at most store in the map.
*/
class Solution {
    public String customSortString(String S, String T) {
        
        if(S == null || S.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character, Integer> map = new HashMap<>(); //character frequency map
        
        for( char c: T.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        
        for(char c: S.toCharArray()){
            if(map.containsKey(c)){
                int itrs = map.get(c);
                
                for(int i=0; i < itrs; i++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        
        // iterating over the remaining characters
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int itrs= entry.getValue();
            Character c= entry.getKey();
            
            for(int i=0; i < itrs; i++){
                sb.append(c);
            }
        }

        return sb.toString();
        
    }
}

// Problem-2: Longest Substring Without Repeating Characters
/**
Iterative solution using hashmap and sliding window technique. where key is the character itself and the value is the index+1 of its occurance. Whenever a similar character is seen again in the given string, update its position in the hashmap and also adjust the window's starting index to the index of the character where it was seen last time. 
TC = O(n) where n is the len of the string s
SC = O(1) at max only 26 characters will be stored in the hashmap
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow=0; // slow pointer, i will be the fast pointer
        int longestSubstrLen = Integer.MIN_VALUE;
        
        for(int i=0; i< s.length(); i++){
            char cur = s.charAt(i);
          if(map.containsKey(cur)){
              slow = Math.max(slow, map.get(cur)); // choosing max of slow in order to avoid moving slow pointer backwards
          }
            longestSubstrLen = Math.max(longestSubstrLen, (i-slow) +1); // i is the fast pointer here
            map.put(cur, i+1); // putting the new position of the character seen again
        }
        return longestSubstrLen;
    }
}
