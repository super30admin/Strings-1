class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Hashmap to store last index of a character
        Map<Character, Integer> hmap = new HashMap<>();
        
        int start=0; // start index of substring
        int outLen=0; // length of substring- output
        // Iterate through the string
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            // if the character is repeated then update start of substring
            if(hmap.containsKey(ch)){
                start = Math.max(hmap.get(ch)+1, start);
            }
            // calculate substring length and store max
            outLen = Math.max(i-start+1, outLen);
            // Put the latest index of character in hashmap
            hmap.put(ch, i);
        }
        return outLen;
    }
}
// TC- O(length of string)
// SC- O(#unique characters in string)
/* 
Logic- 
1. Start from 0th index and assume outLen to be 0.
2. The start index needs to be changed to maximum of index- repeated character index+1 or start as soon as a charcater is repeated.
3. Maximum function is used to ensure that the repeated character has been removed from current substring.
4. Calculate the outLen and retain maximum outLen
5. Update the current index in hashMap for given character.
*/
